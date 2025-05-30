# ライブラリのインポート
import cv2                             # OpenCVライブラリをインポート
import mediapipe as mp                 # MediaPipeライブラリをインポート

# MediaPipeのFace Meshモデルを初期化
mp_face_mesh = mp.solutions.face_mesh
face_mesh = mp_face_mesh.FaceMesh()

# MediaPipeの描画ユーティリティを初期化
mp_drawing = mp.solutions.drawing_utils
drawing_spec = mp_drawing.DrawingSpec(thickness=1, circle_radius=1)  # 描画の設定（線の太さ、円の半径）

# カメラを開く
cap = cv2.VideoCapture(0)
cap.set(cv2.CAP_PROP_FRAME_WIDTH, 640)  # 幅を設定
cap.set(cv2.CAP_PROP_FRAME_HEIGHT, 480) # 高さを設定

# 各フレームを繰り返し処理
while True:
    # フレームを取得（取得に失敗したら終了）
    success, frame = cap.read()
    if not success:
        print("カメラからフレームを取得できませんでした。")
        break

	# 各フレームを処理
    # frameはBGRなので、RGBにして処理する
    frame_rgb = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)

    # Face Meshモデルで画像を処理
    results = face_mesh.process(frame_rgb)

    # 顔のランドマークが検出された場合
    if results.multi_face_landmarks:
        # 検出された顔の数だけループ
        for face_landmarks in results.multi_face_landmarks:
            # 顔のランドマークを描画
            mp_drawing.draw_landmarks(
                image=frame,
                landmark_list=face_landmarks,
                connections=mp_face_mesh.FACEMESH_TESSELATION,
                landmark_drawing_spec=drawing_spec,
                connection_drawing_spec=drawing_spec
            )

    # フレームを表示　→ Jupyterでは表示しない方がよい
    cv2.imshow('Face Mesh', frame)
    
    # 'q'キーが押されたらループを抜ける
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

# カメラを解放し、ウィンドウを閉じる
cap.release()
cv2.destroyAllWindows()