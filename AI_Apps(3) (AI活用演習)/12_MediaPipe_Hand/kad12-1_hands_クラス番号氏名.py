# 必要なライブラリをインポートします
import cv2
import mediapipe as mp

# mediapipeから手の検出を行うオブジェクトを作成します
# 手検出のソリューションを読み込みます
mp_hands = mp.solutions.hands
# 最低限の検出信頼度と追跡信頼度はそれぞれ0.5（50%）に設定
hands = mp_hands.Hands(min_detection_confidence=0.5, min_tracking_confidence=0.5)
# withを使用する場合
#with mp_hands.Hands(min_detection_confidence=0.5, min_tracking_confidence=0.5) as hands:

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
        # 検出されたすべての手について
        for hand_landmarks in results.multi_hand_landmarks:
            # 手のランドマーク（指の関節部分など）と、それらをつなぐ線を描画します
            mp_drawing.draw_landmarks(
                image = image, 
                landmark_list = hand_landmarks,
                connections = mp_hands.HAND_CONNECTIONS) #drawing_specはデフォルト値を使用
            
    # 描画結果の画像を表示します（cv2.imshow）
    cv2.imshow('2230033', image)

    # 'q'キーで終了
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

# カメラを解放し、ウィンドウを閉じる
cap.release()
cv2.destroyAllWindows()