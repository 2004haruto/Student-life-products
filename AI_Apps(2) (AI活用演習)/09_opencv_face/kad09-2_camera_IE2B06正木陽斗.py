# 必要なライブラリのインポート
import matplotlib.pyplot as plt
import cv2
from mosaic import mosaic  # 自作のmosaic.py内のmosaic関数をインポート

# Haar-cascade分類器を読み込んでモデル作成
cascade_file = "haarcascade_frontalface_alt.xml"
cascade = cv2.CascadeClassifier(cascade_file)

# カメラを開く
cap = cv2.VideoCapture(0)

# 各フレームを繰り返し処理
while True:
    # フレームを取得
    ret, frame = cap.read()
    if not ret:
        break

	# 各フレームに処理
    # 画像を読み込み、グレースケールに変換する
    gray_frame = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)

    # Haar-cascade分類器を用いて顔を検出する
    face_list = cascade.detectMultiScale(gray_frame, scaleFactor=1.1, minNeighbors=5, minSize=(100, 100))

    #（顔が検出されない場合の処理は不要）

    # 検出された顔にモザイクをかける
    for (x, y, w, h) in face_list:
        frame = mosaic(frame, (x, y, x + w, y + h), size=15)

    # フレームを表示　→ Jupyterでは表示しない方がよい
    cv2.imshow("2230033", frame)

    # 'q'キーが押されたらループを抜ける
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

# カメラを解放し、ウィンドウを閉じる
cap.release()
cv2.destroyAllWindows()