# 必要なライブラリのインポート
import cv2
import mediapipe as mp
import numpy as np

# try-except-finallyでエラー処理を追加
try:
    # MediaPipeのFace Meshモデルを初期化
    mp_face_mesh = mp.solutions.face_mesh
    face_mesh = mp_face_mesh.FaceMesh(refine_landmarks=True)

    # オーバーレイする画像のパスを定義
    eye_overlay_image_path = 'black.png'

    # オーバーレイ画像を読み込む（アルファチャンネル付き）
    original_overlay_image = cv2.imread(eye_overlay_image_path, cv2.IMREAD_UNCHANGED)

    # オーバーレイ画像が読み込めない場合のエラー処理
    if original_overlay_image is None:
        raise FileNotFoundError("オーバーレイ画像が見つかりません。パスを確認してください。")

    # 画像にアルファチャンネルがない場合、アルファチャンネルを1.0に設定
    if original_overlay_image.shape[2] == 3:
        # アルファチャンネルがない場合、アルファチャンネルを追加
        alpha_channel = np.ones((original_overlay_image.shape[0], original_overlay_image.shape[1]), dtype=original_overlay_image.dtype) * 255
        original_overlay_image = np.dstack([original_overlay_image, alpha_channel])

    # カメラのキャプチャを開始
    cap = cv2.VideoCapture(0)
    cap.set(cv2.CAP_PROP_FRAME_WIDTH, 640)
    cap.set(cv2.CAP_PROP_FRAME_HEIGHT, 480)

    # カメラの処理ループ
    while cap.isOpened():
        success, face_image = cap.read()  # カメラから画像を取得
        if not success:
            print("カメラフレームを取得できませんでした。")
            continue

        # 画像をRGB色空間に変換（MediaPipe用）
        face_image_rgb = cv2.cvtColor(face_image, cv2.COLOR_BGR2RGB)

        # 顔のランドマークを検出
        results = face_mesh.process(face_image_rgb)

        # ランドマークが検出された場合
        if results.multi_face_landmarks:
            for face_landmarks in results.multi_face_landmarks:
                # 指定したランドマークの座標を取得する関数
                coords = lambda landmark_id: (
                    int(face_landmarks.landmark[landmark_id].x * face_image.shape[1]),
                    int(face_landmarks.landmark[landmark_id].y * face_image.shape[0])
                )

                # 目の中心を計算
                eye_c = (np.array(coords(145)) + np.array(coords(373))) // 2  # 左目と右目の間の中心を取る

                # 目のオーバーレイ画像のサイズを計算
                overlay_width = int(np.linalg.norm(np.array(coords(124)) - np.array(coords(353))))


                overlay_height = int(overlay_width * original_overlay_image.shape[0] / original_overlay_image.shape[1])

                # それぞれのオーバーレイ画像をリサイズ
                overlay_image_resized = cv2.resize(original_overlay_image, (overlay_width, overlay_height))

                # 目のオーバーレイ画像の開始と終了座標
                start_x = max(eye_c[0] - overlay_width // 2, 0)
                start_y = max(eye_c[1] - overlay_height // 2, 0)
                end_x = min(start_x + overlay_width, face_image.shape[1])
                end_y = min(start_y + overlay_height, face_image.shape[0])

                # オーバーレイ画像の合成
                left_overlay = overlay_image_resized[:end_y-start_y, :end_x-start_x]
                alpha_mask = left_overlay[:, :, 3] / 255.0
                for c in range(3):  # RGBチャンネル
                    face_image[start_y:end_y, start_x:end_x, c] = (
                        alpha_mask * left_overlay[:, :, c] +
                        (1 - alpha_mask) * face_image[start_y:end_y, start_x:end_x, c]
                    )

        # ウィンドウ名を学籍番号に設定して表示
        cv2.imshow('2230021', face_image)

        # 'q'キーで終了
        if cv2.waitKey(5) & 0xFF == ord('q'):
            break

except Exception as e:
    print(f"エラーが発生しました: {e}")
finally:
    # リソースを解放
    cap.release()
    cv2.destroyAllWindows()
