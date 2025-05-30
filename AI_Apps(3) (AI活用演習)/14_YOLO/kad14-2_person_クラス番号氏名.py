# 必要なライブラリのインポート
from ultralytics import YOLO
import cv2

# モデルの準備
# YOLOモデルの読み込み
model = YOLO("yolov8n.pt")  # 適切なモデルファイルを指定

# カメラのキャプチャ開始
cap = cv2.VideoCapture(0)
cap.set(cv2.CAP_PROP_FRAME_WIDTH, 640)
cap.set(cv2.CAP_PROP_FRAME_HEIGHT, 480)

# カメラの処理はtry～except～finallyで書いておくとよい
try:
    while True:
        # フレームを取得
        ret, frame = cap.read()
        if not ret:
            print("フレームの取得に失敗しました。")
            break

        # フレームに対してYOLOモデルで推論を実行
        results = model(frame)

        # 検出された人の数をカウント
        person_count = 0
        for result in results:
            detected_classes = result.boxes.cls.tolist() if result.boxes else []
            for cls in detected_classes:
                if result.names[int(cls)] == "person":
                    person_count += 1

        # 推論結果をフレームに描画
        annotated_frame = results[0].plot() if len(results) > 0 else frame

        # 人数を左上に描画
        cv2.putText(annotated_frame, f"Person: {person_count}", (10, 30),
                    cv2.FONT_HERSHEY_DUPLEX, 1.0, color=(0, 0, 255))

        # フレームを表示
        cv2.imshow("2230033", annotated_frame)

        # 'q'キーで終了
        if cv2.waitKey(1) & 0xFF == ord('q'):
            break

except Exception as e:
    print(f"エラーが発生しました: {e}")
finally:
    # リソースを解放
    cap.release()
    cv2.destroyAllWindows()
