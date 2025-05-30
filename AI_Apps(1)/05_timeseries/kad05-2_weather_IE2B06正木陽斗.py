# CSVファイルからデータを読み込む
import pandas as pd
df = pd.read_csv('temp_dataset.csv')

# 時系列を指定してTimeSeriesを作る
from darts.timeseries import TimeSeries
series = TimeSeries.from_dataframe(df, time_col='date', value_cols=['temperature'])

# 時系列をplotして確認してもよい
import matplotlib.pyplot as plt
series.plot()
plt.show()

# 訓練用とテスト用に分ける（最後の365日分をテスト用にする）
train, val = series[:-365], series[-365:]

# （分けた後、表示して確認してもよい）
train.plot(label="training")
val.plot(label="validation")
plt.legend()
plt.show()

# モデルの構築（kad05-1と同じモデルで試す場合）
## 3-1. NaiveSeasonal
# モデルを使用するためにインポート
from darts.models import NaiveSeasonal

# モデルの作成（Kは自分で考える）
model_NS = NaiveSeasonal(K=365)

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

# モデルの作成（random_state=学籍番号, lagsは自分で調整）
model_LR = LinearRegressionModel(random_state=2230033, lags=365)

# fitに学習用データを入れて学習
model_LR.fit(train)

# 4. 性能評価
## 4-1. 予測値の計算と確認
# NaiveSeasonalで365日分予測
pred_NS= model_NS.predict(365)

# ExponentialSmoothingで365日分予測
pred_Exp = model_Exp.predict(365)

# LinearRegressionModelで365日分予測
pred_LR = model_LR.predict(365)

# グラフで365日分のみ表示して確認してもよい。
plt.plot(pred_NS.values(), label="NaiveSeasonal Prediction")
plt.plot(pred_Exp.values(), label="ExponentialSmoothing Prediction")
plt.plot(pred_LR.values(), label="LinearRegressionModel Prediction")
plt.legend()
plt.show()

## 4-2. 性能評価
# 決定係数（r2_score）
from darts.metrics import r2_score
print("---r2_score---")
print("NaiveSeasonal:", r2_score(val, pred_NS))
print("ExponentialSmoothing:", r2_score(val, pred_Exp))
print("LinearRegression:", r2_score(val, pred_LR))

# MAPE
from darts.metrics import mape
print("---mape---")
print("NaiveSeasonal:", mape(val, pred_NS))
print("ExponentialSmoothing:", mape(val, pred_Exp))
print("LinearRegression:", mape(val, pred_LR))