# 必要なライブラリのインポート
import matplotlib.pyplot as plt
import cv2
from mosaic import mosaic  # 自作のmosaic.py内のmosaic関数をインポート

# Haar-cascade分類器を読み込んでモデル作成
cascade_file = "haarcascade_frontalface_alt.xml"
cascade = cv2.CascadeClassifier(cascade_file)

# 画像リスト
image_files = ["family1.png", "family2.png"]

for img_path in image_files:
    # 画像を読み込み、グレースケールに変換する
    img = cv2.imread(img_path)
    img_gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)

    # Haar-cascade分類器を用いて顔を検出する
    face_list = cascade.detectMultiScale(img_gray, minSize=(150, 150))

    # 顔が検出されなかった場合
    if len(face_list) == 0:
        print(f"{img_path}: 顔が見つかりません")
        continue

    # 検出された顔の数だけ処理する
    for (x, y, w, h) in face_list:
        # 顔の座標を出力する
        print(f"{img_path}: 顔の座標=", x, y, w, h)

        # モザイク処理を適用
        img = mosaic(img, (x, y, x + w, y + h), size=15)

    # 出力画像の保存
    output_path = f"2230033_{img_path}"
    cv2.imwrite(output_path, img)

    # 出力画像の表示
    plt.imshow(cv2.cvtColor(img, cv2.COLOR_BGR2RGB))
    plt.axis('off')
    plt.show()
