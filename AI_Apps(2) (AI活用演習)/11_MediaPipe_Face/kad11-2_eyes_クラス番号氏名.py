# 必要なライブラリのインポート
import cv2
import mediapipe as mp
import numpy as np

# 課題では、try～except～finallyを使ってエラー処理
try:
    # 3-1. モデルの読み込み（初期化） ####
    mp_face_mesh = mp.solutions.face_mesh
    face_mesh = mp_face_mesh.FaceMesh(static_image_mode=False, max_num_faces=1, min_detection_confidence=0.5)

    # 4.1 オーバーレイする画像のパスを定義（leftとright）
    # パスの定義
    left_eye_path = 'kirakira_left.png'
    right_eye_path = 'kirakira_right.png'

    # 画像を読み込む（透明度も含め）####
    left_eye_img = cv2.imread(left_eye_path, cv2.IMREAD_UNCHANGED)
    right_eye_img = cv2.imread(right_eye_path, cv2.IMREAD_UNCHANGED)

    if left_eye_img is None or right_eye_img is None:
        raise FileNotFoundError("オーバーレイ画像が見つかりません。パスを確認してください。")
    
    # カメラのキャプチャを開始（解像度を設定してもよい）
    cap = cv2.VideoCapture(0)
    cap.set(cv2.CAP_PROP_FRAME_WIDTH, 640)
    cap.set(cv2.CAP_PROP_FRAME_HEIGHT, 480)

    # カメラの処理
    while cap.isOpened():
        success, face_image = cap.read() # カメラから画像を読み込む
        if not success:
            print("Ignoring empty camera frame.") # 読み込み失敗時のメッセージ
            continue

        # 4.2 顔を含む画像を読み込んでRGBに変換
        # 画像の読み込みは済んでいる
        rgb_image = cv2.cvtColor(face_image, cv2.COLOR_BGR2RGB)

        # 4-3. 顔のランドマークを検出
        results = face_mesh.process(rgb_image)

        # 4-4. 指定したランドマークの座標を取得する関数
        if results.multi_face_landmarks:
            for face_landmarks in results.multi_face_landmarks:
                h, w, _ = face_image.shape
                # 指定したランドマークの座標を取得する関数
                def coords(landmark_index):
                    x = int(face_landmarks.landmark[landmark_index].x * w)
                    y = int(face_landmarks.landmark[landmark_index].y * h)
                    return (x, y)

                # 4-5. 使用する座標を取得（何を取得するか考える）
                left_eye_c = (np.array(coords(144)) + np.array(coords(160))) // 2
                right_eye_c = (np.array(coords(374)) + np.array(coords(386))) // 2

                # 4-6. オーバーレイ画像の幅を調整（どうやって決めるかを考える）
                overlay_width = overlay_height = 50

                # 左右それぞれのオーバーレイ画像をリサイズ
                left_eye_resized = cv2.resize(left_eye_img, (overlay_width, overlay_height))
                right_eye_resized = cv2.resize(right_eye_img, (overlay_width, overlay_height))

                # 4-7 各オーバーレイ画像の開始と終了座標を計算
                left_start = (left_eye_c[0] - overlay_width // 2, left_eye_c[1] - overlay_height // 2)
                right_start = (right_eye_c[0] - overlay_width // 2, right_eye_c[1] - overlay_height // 2)

                ## 4-8. オーバーレイ画像を元の画像上に合成
                def overlay_image(background, overlay, position):
                    x, y = position
                    h, w, _ = overlay.shape
                    alpha_overlay = overlay[:, :, 3] / 255.0  # アルファチャンネルの正規化
                    alpha_background = 1.0 - alpha_overlay

                    for c in range(0, 3):  # BGRの3チャンネル分をループ
                        background[y:y+h, x:x+w, c] = (
                            alpha_overlay * overlay[:, :, c] +
                            alpha_background * background[y:y+h, x:x+w, c]
                        )

                # 左右それぞれの画像のアルファ（透明度）と色情報を抽出


                # 各オーバーレイ画像を元の画像上に合成
                # 左目と右目にオーバーレイ
                overlay_image(face_image, left_eye_resized, left_start)
                overlay_image(face_image, right_eye_resized, right_start)

        # cv2.imshowで画像を表示（ウインドウ名を自分の学籍番号にする）
        cv2.imshow('2230033', face_image)

        # 'q'キーで終了
        if cv2.waitKey(5) & 0xFF == ord('q'):
            break

except Exception as e:
    print(f"エラーが発生しました: {e}")
finally:
    # リソースを解放
    cap.release()
    cv2.destroyAllWindows()
