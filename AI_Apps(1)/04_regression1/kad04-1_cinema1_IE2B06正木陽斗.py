# pandasライブラリを読み込む
import pandas as pd

# csvの読み込み
df = pd.read_csv('cinema-dataset.csv')

# matplotlibライブラリをインポートする
import matplotlib.pyplot as plt

# 各列の散布図を描画する
# DataFrameのplotメソッドを使用し、各列をx軸、sales列をy軸として散布図を描画する
df.plot(kind='scatter', x='SNS1', y='sales')
df.plot(kind='scatter', x='SNS2', y='sales')
df.plot(kind='scatter', x='actor', y='sales')
df.plot(kind='scatter', x='original', y='sales')

# 描画したグラフを表示する
plt.show()

# 特微量の取り出し
#特徴量、説明変数、入力
x = df.loc[:, 'SNS1':'original']   # 'SNS1'列から'original'列までの特微量を抽出

# 正解ラベルの取り出し
#正解ラベル、目的変数、出力
t = df['sales']

# 訓練データとテストデータに分割する
# 関数のインポート
from sklearn.model_selection import train_test_split

# データの分割
x_train, x_test, y_train, y_test = train_test_split(x, t, test_size=0.3, random_state=2230033)

# モデルの準備（SVR(kernel='linear')）
# Support Vector Machine (SVM)のインポート
from sklearn.svm import SVR

# SVR（Support Vector Regression）モデルのインスタンス化
# kernel="linear"で線形カーネルを使用する
model = SVR(kernel="linear")

# 学習
model.fit( x_train , y_train )

# 予測
# 新しいデータ（SNS1、SNS2、actor、original）を渡して予測を行う
new_data = [[150,700,300,1]]
print(f"予測値：{model.predict(new_data)}")

# モデルの評価
# テストデータを使って学習済みモデルの予測結果と正解ラベルとの平均絶対誤差を計算する
# 関数のインポート
from sklearn.metrics import mean_absolute_error

## MAE
#テストデータを使って学習済みモデルの予測結果と正解ラベルとの平均絶対誤差を計算する
pred = model.predict(x_test) # 予測
mae = mean_absolute_error(y_true=y_test, y_pred=pred) #正解ラベルと予測結果の誤差平均を求める
print(f"平均絶対誤差: {mae}")

## 決定係数（score）
# テストデータで学習モデルを評価し、スコアを計算する
print(f"score:{model.score(x_test,y_test)}")