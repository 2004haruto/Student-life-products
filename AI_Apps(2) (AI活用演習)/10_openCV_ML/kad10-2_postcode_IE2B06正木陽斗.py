# 必要なライブラリのインポート
import cv2
import matplotlib.pyplot as plt
import numpy as np
import pickle

# detect_postcode関数が使えるようにインポート
from detect_postcode import detect_postcode

# predict_postcode関数の定義
def predict_postcode(target_filename):
    # 学習済み手書き数字の機械学習モデルを読み込む
    model_filename = 'digits.pkl'
    with open(model_filename, 'rb') as file:
        model = pickle.load(file)

    # はがきの画像から、郵便番号の領域を検出
    # detect_postcode関数を使用する
    cnts, img = detect_postcode(target_filename)

    # 検出した郵便番号を格納するリスト
    post_code = []

    # 読み込んだデータをプロットするためのforループ
    for i, box in enumerate(cnts):
        # 領域の座標と大きさを取得
        x, y, w, h = box

        # 画像の枠線の内側のデータを取り出す
        img_cut = img[y:y+h, x:x+w]

        """ データを学習済みデータに合わせる """
        # グレースケールに変換
        target_image = cv2.cvtColor(img_cut, cv2.COLOR_BGR2GRAY)

        # リサイズ
        target_image = cv2.resize(target_image, (8, 8))

        # 白黒反転、0-15の範囲にする
        target_image = 15 - (target_image / 255 * 15).astype(np.uint8)

        # 一次元に変換
        img_1d = target_image.reshape(1, -1)

        # 機械学習で予測する
        res = model.predict(img_1d)[0]

        """ 画面に出力 """
        plt.subplot(1, len(cnts), i + 1)  # 表示領域に分割し指定
        plt.imshow(img_cut)              # 表示領域に画像を貼り付け
        plt.axis("off")                  # 軸を非表示
        plt.title(str(res))              # 画像タイトルを予測結果にする

        # 郵便番号をpost_codeリストに追加
        post_code.append(str(res))

    # 郵便番号を文字列に結合して返す
    return ''.join(post_code)

# ファイル名を指定して検出する
target_filename = 'hagaki1.png'  # 対象の画像ファイルパスを指定
post_code = predict_postcode(target_filename)
print(f"郵便番号は {post_code} です")
plt.show()
