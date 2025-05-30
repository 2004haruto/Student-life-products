# 2.　データの準備
import matplotlib.pyplot as plt

# データのロード
from darts.datasets import AirPassengersDataset
series = AirPassengersDataset().load()

# CSVファイルからの読み込む場合
import pandas as pd
df = pd.read_csv('AirPassengers.csv')

# 時系列を指定してTimeSeriesを作る
from darts.timeseries import TimeSeries
series = TimeSeries.from_dataframe(df, time_col='Month', value_cols=['#Passengers'])

# 訓練用とテスト用に分ける
train, val = series[:-36], series[-36:]
train.plot(label="training")
val.plot(label="validation")
plt.show()

# 3. モデルの構築
## 3-1. NaiveSeasonal
# モデルを使用するためにインポート
from darts.models import NaiveSeasonal

# モデルの作成
model_NS = NaiveSeasonal(K=12)
# fitに学習用データを入れて学習
model_NS.fit(train)

## 3-2. ExponentialSmoothing
# モデルを使用するためにインポート
from darts.models import ExponentialSmoothing

# モデルの作成（random_state=学籍番号）
model_Exp = ExponentialSmoothing(random_state=2230033)

# fitに学習用データを入れて学習
model_Exp.fit(train)

## 3-3. LinearRegressionModel
# モデルを使用するためにインポート
from darts.models import LinearRegressionModel

# モデルの作成
model_LR = LinearRegressionModel(random_state=2230033, lags=12)

# fitに学習用データを入れて学習
model_LR.fit(train)

# 4. 性能評価
## 4-1. 予測値の計算と確認
# NaiveSeasonalで36か月分予測
pred_NS = model_NS.predict(36)

# ExponentialSmoothingで36か月分予測
pred_Exp = model_Exp.predict(36)
                             
# LinearRegressionModelで36か月分予測
pred_LR = model_LR.predict(36)

# グラフは不要

## 4-2. 性能評価
# 決定係数（r2_score）
from darts.metrics import r2_score
print("---r2_score---")
print("NaiveSeasonal",r2_score(val, pred_NS))
print("ExponentialSmoothing",r2_score(val, pred_Exp))
print("LinearRegression", r2_score(val, pred_LR))

# MAPE
from darts.metrics import mape
#自分でやってみよう
print("---mape---")
print("NaiveSeasonal",mape(val, pred_NS))
print("ExponentialSmoothing",mape(val, pred_Exp))
print("LinearRegression", mape(val, pred_LR))