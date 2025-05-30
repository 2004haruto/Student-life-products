# pandasライブラリのインポート
import pandas as pd

# データの読み込み
df = pd.read_csv('wine_dataset.csv')

# 特微量を抽出して変数xに代入
X = df.drop('quality', axis=1) 

# 正解データを抽出して変数tに代入
t = df['quality']  


# 訓練用データとテスト用に分割
## テストデータの割合を30%、random_stateを学籍番号にする。

# 関数のインポート
from sklearn.model_selection import train_test_split
#データの分割
X_train, X_test, y_train, y_test = train_test_split(X, t, test_size=0.3, random_state=2230033)


# モデルの準備
# LinearSVCを使ってモデル作成
from sklearn.svm import LinearSVC # モジュールのインポート

model = LinearSVC()

# モデルの学習
model.fit(X_train, y_train)

# モデルを評価（修正する）
score_train = model.score(X_train, y_train)
score_test = model.score(X_test, y_test)
print(f"訓練データの正解率は{score_train}") #0.5781948168007149
print(f"テストデータの正解率は{score_test}") #0.5541666666666667