# 必要なライブラリをインポートします
import cv2
import mediapipe as mp
import pyautogui
import numpy as np

# mediapipeから手の検出を行うオブジェクトを作成します
# 手検出のソリューションを読み込みます
mp_hands = mp.solutions.hands
# 最低限の検出信頼度と追跡信頼度はそれぞれ0.5（50%）に設定
hands = mp_hands.Hands(min_detection_confidence=0.5, min_tracking_confidence=0.5)
# withを使用する場合
#with mp_hands.Hands(min_detection_confidence=0.5, min_tracking_confidence=0.5) as hands:

# MediaPipeの描画ユーティリティを初期化
# MediaPipeの描画ユーティリティを初期化
mp_drawing = mp.solutions.drawing_utils
# 今回はdrawing_specを使用しない
# drawing_spec = mp_drawing.DrawingSpec(thickness=1, circle_radius=1)  # 描画の設定（線の太さ、円の半径）

# ウェブカメラからの入力を開始します（解像度を設定してもよい）
cap = cv2.VideoCapture(0)

# カメラが開いている限り処理を続けます
while cap.isOpened():
    # カメラからフレームを一枚読み込みます
    success, image = cap.read()        
    # カメラからの入力がない場合は処理をスキップします
    if not success:
        print("カメラフレームが空です。スキップします。")
        continue

    # 画像を左右反転させ、BGR形式からRGB形式に変換します（mediapipeはRGB形式を前提としています）
    image = cv2.flip(image, 1)
    image_rgb = cv2.cvtColor(image, cv2.COLOR_BGR2RGB)

    # 手の検出を行います
    results = hands.process(image_rgb)

    # 手が検出された場合
    if results.multi_hand_landmarks:
        for hand_landmarks in results.multi_hand_landmarks:
            # 確認のため、手のランドマークを描画してもいい
            mp_drawing.draw_landmarks(
                image, hand_landmarks, mp_hands.HAND_CONNECTIONS
            )

            # 人差し指の先端の座標を取得します
            index_finger_tip = hand_landmarks.landmark[mp_hands.HandLandmark.INDEX_FINGER_TIP]
            x_index, y_index = index_finger_tip.x, index_finger_tip.y

            # 親指の先端の座標を取得します
            thumb_tip = hand_landmarks.landmark[mp_hands.HandLandmark.THUMB_TIP]
            x_thumb, y_thumb = thumb_tip.x, thumb_tip.y

            # スクリーンのサイズを取得します
            screen_width, screen_height = pyautogui.size()

            # 正規化された座標をスクリーンの座標に変換します
            mouse_x = int(x_index * screen_width)
            mouse_y = int(y_index * screen_height)

            # マウスカーソルを新しい位置に移動します
            pyautogui.moveTo(mouse_x, mouse_y)

            # 親指と人差し指の座標が近いとき、アラートを表示します
            distance = np.sqrt((x_index - x_thumb) ** 2 + (y_index - y_thumb) ** 2)
            if distance < 0.05:  # 距離の閾値を調整
                response = pyautogui.confirm(
                    text="親指と人差し指が近いです！",
                    title="アラート",
                    buttons=["OK"]
                )
                print("アラート: 親指と人差し指が近いです！")

    # カメラ画像が確認できるように表示します。鏡のような表示にする。（cv2.imshow）
    cv2.imshow('2230033', image)


    # 'q'キーで終了
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

# カメラを解放し、ウィンドウを閉じる
cap.release()
cv2.destroyAllWindows()