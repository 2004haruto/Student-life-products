# 必要なライブラリのインポート
import pickle
import cv2
import matplotlib.pyplot as plt

# 手書き数字を予測する関数
def predict_digit(target_filename):
    
    # 学習済みモデルを読み込む
    model_filename = 'digits.pkl'
    with open(model_filename, 'rb') as file:
        model = pickle.load(file)

    # 画像を読み込んで前処理をする
    # 画像を読み込む
    target_image = cv2.imread(target_filename, cv2.IMREAD_GRAYSCALE)

    # サイズを8x8に縮小する
    target_image = cv2.resize(target_image, (8, 8))

    # 白黒反転して、輝度を0~15の範囲に調整する
    target_image = 15 - target_image // 16

    # 表示して確認
    # plt.imshow(target_image, cmap='gray')
    # plt.title("Processed Image")
    # plt.show()

    # 画像を1次元配列に変換する
    target_image = target_image.reshape(-1, 64)
    # モデルで予測する
    prediction = model.predict(target_image)

    # 予測結果を返す
    return prediction[0]

# ファイル名を指定して数字を予測する
filename = 'template.png'  # ここに対象画像のパスを指定
n = predict_digit(filename)
print(f"{filename}は = 数字の{n}ですね！")
