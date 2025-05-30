# 2-1 学習用データの準備
## 2-1-1 CSVファイルの読み込み
# pandasライブラリを読み込む
import pandas as pd

# csvの読み込み
df = pd.read_csv('cinema-dataset.csv')

# 先頭数行を表示して確認してもよい
print(df.head(3))

## 2-1-2. 入力と出力の取り出し
# 特微量の取り出し
x = df[['SNS1', 'SNS2', 'actor', 'original']]

# 正解ラベルの取り出し
t = df['sales']

## 2-1-3. 訓練データとテストデータに分割する
# 関数を使うためにインポート
from sklearn.model_selection import train_test_split
# データの分割
x_train, x_test, y_train, y_test = train_test_split(x, t, test_size=0.3, random_state=2230033)

# 2-2. モデルの構築（ElasticNet）
# モデルを使用するためにインポート
from sklearn.linear_model import ElasticNet
from sklearn.metrics import mean_absolute_error, r2_score

# モデルの作成
model_El = ElasticNet()

# fitに学習用データを入れて学習
model_El.fit(x_train, y_train)

# scoreの確認（テスト用データをのMAEとscoreを計算して表示）
y_pred_El = model_El.predict(x_test)
mae_El = mean_absolute_error(y_test, y_pred_El)
score_El = r2_score(y_test, y_pred_El)

print("ElasticNet MAE:", mae_El)
print("ElasticNet score:", score_El)

# 2-3. モデルの構築（Ridge）
# モデルを使用するためにおインポート
from sklearn.linear_model import Ridge

# モデルの作成
model_Ridge = Ridge()

# fitに学習用データを入れて学習
model_Ridge.fit(x_train, y_train)

# scoreの確認（テスト用データをのMAEとscoreを計算して表示）
y_pred_Ridge = model_Ridge.predict(x_test)
mae_Ridge = mean_absolute_error(y_test, y_pred_Ridge)
score_Ridge = r2_score(y_test, y_pred_Ridge)

print("Ridge MAE:", mae_Ridge)
print("Ridge score:", score_Ridge)

# 2-4. モデルの構築（SVR(kernel='rbf')）
# モデルを使用するためにおインポート（同じファイル内でインポート済みなら不要）
from sklearn.svm import SVR

# モデルの作成
model_SVRr = SVR(kernel='rbf')

# fitに学習用データを入れて学習
model_SVRr.fit(x_train, y_train)

# scoreの確認（テスト用データをのMAEとscoreを計算して表示）
y_pred_SVRr = model_SVRr.predict(x_test)
mae_SVRr = mean_absolute_error(y_test, y_pred_SVRr)
score_SVRr = r2_score(y_test, y_pred_SVRr)

print("SVR(rbf) MAE:", mae_SVRr)
print("SVR(rbf) score:", score_SVRr)

# 2-5. モデルの構築（RandomForest）
# モデルを使用するためにおインポート
from sklearn.ensemble import RandomForestRegressor

# モデルの作成
model_RF = RandomForestRegressor(random_state=2230033)

# fitに学習用データを入れて学習
model_RF.fit(x_train, y_train)

# scoreの確認（テスト用データをのMAEとscoreを計算して表示）
# 精度の確認
y_pred_RF = model_RF.predict(x_test)
mae_RF = mean_absolute_error(y_test, y_pred_RF)
score_RF = r2_score(y_test, y_pred_RF)

print("RandomForest MAE:", mae_RF)
print("RandomForest score:", score_RF)

##### 課題：4つの結果を比較 ###
print("最もよいアルゴリズム：RF")
print("理由：誤差が少ないから")
