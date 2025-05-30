# OpenCVをインポート
import cv2

# Matplotlibをインポート
import matplotlib.pyplot as plt

# 画像ファイルを読み込む
img = cv2.imread("woman.png")

## 表示して確認、切り取り範囲の検討（範囲を決めたらコメントアウトしてよい）
#plt.imshow(cv2.cvtColor(img, cv2.COLOR_BGR2RGB))

# 画像の一部を切り出し、サイズを変更し、ファイルに保存する
img2 = img[250:650, 800:1150]
img2 = cv2.resize(img2, (400, 500))
cv2.imwrite("out-resize-woman.png", img2)

# 軸を非表示にして、画像を表示する
plt.axis("off")

plt.imshow(cv2.cvtColor(img2, cv2.COLOR_BGR2RGB))
plt.show()