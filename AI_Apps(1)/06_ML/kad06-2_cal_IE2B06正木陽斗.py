# ■課題06-2 カリフォルニアの平均住宅価格の予測

# 1. 課題内容とCSVファイルを確認
# 使用するデータセット：california.csv

# 2. CSVファイルのデータをpandasのDataFrameとして読み込む
import pandas as pd

# データの読み込み
df = pd.read_csv('california.csv')

# 先頭数行を表示して確認
# print(df.head(3))

# 3. 入力と出力に分割
# 特徴量の取り出し
X = df[['MedInc', 'HouseAge', 'AveRooms', 'AveBedrms', 'Population', 'AveOccup', 'Latitude', 'Longitude']]
# 正解ラベルの取り出し
y = df['MedHouseVal']

# 4. 学習用データとテスト用データに分割
from sklearn.model_selection import train_test_split

# データの分割
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.3, random_state=2230033)

# 5. 複数のアルゴリズムについて以下を実施する

# 5-1. モデルの構築（ElasticNet）
from sklearn.linear_model import ElasticNet
from sklearn.metrics import mean_absolute_error, r2_score

# モデルの作成
model_El = ElasticNet()
# 学習
model_El.fit(X_train, y_train)

# テストデータでの評価
y_pred_El = model_El.predict(X_test)
mae_El = mean_absolute_error(y_test, y_pred_El)
score_El = r2_score(y_test, y_pred_El)

print("ElasticNet MAE:", mae_El)
print("ElasticNet score:", score_El)

# 5-2. モデルの構築（Ridge）
from sklearn.linear_model import Ridge

# モデルの作成
model_Ridge = Ridge()
# 学習
model_Ridge.fit(X_train, y_train)

# テストデータでの評価
y_pred_Ridge = model_Ridge.predict(X_test)
mae_Ridge = mean_absolute_error(y_test, y_pred_Ridge)
score_Ridge = r2_score(y_test, y_pred_Ridge)

print("Ridge MAE:", mae_Ridge)
print("Ridge score:", score_Ridge)

# 5-3. モデルの構築（SVR）
from sklearn.svm import SVR

# モデルの作成
model_SVR = SVR(kernel='rbf')
# 学習
model_SVR.fit(X_train, y_train)

# テストデータでの評価
y_pred_SVR = model_SVR.predict(X_test)
mae_SVR = mean_absolute_error(y_test, y_pred_SVR)
score_SVR = r2_score(y_test, y_pred_SVR)

print("SVR MAE:", mae_SVR)
print("SVR score:", score_SVR)

# 5-4. モデルの構築（RandomForestRegressor）
from sklearn.ensemble import RandomForestRegressor

# モデルの作成
model_RF = RandomForestRegressor(random_state=2230033)
# 学習
model_RF.fit(X_train, y_train)

# テストデータでの評価
y_pred_RF = model_RF.predict(X_test)
mae_RF = mean_absolute_error(y_test, y_pred_RF)
score_RF = r2_score(y_test, y_pred_RF)

print("RandomForest MAE:", mae_RF)
print("RandomForest score:", score_RF)

# 使用に適しているのは、RF