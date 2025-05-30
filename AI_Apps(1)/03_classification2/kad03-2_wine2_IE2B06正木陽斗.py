# インポート
import pandas as pd

# データの読み込み
df = pd.read_csv('wine_dataset.csv')

# 特微量を抽出して変数xに代入
x = df.drop('quality', axis=1) # 列名を指定する場合はaxis=1を指定

# 正解データを抽出して変数tに代入
t = df['quality']

# 訓練用データとテスト用に分割
# 関数のインポート
from sklearn.model_selection import train_test_split

# データの分割
x_train, x_test, y_train, y_test = train_test_split(x, t , test_size=0.3, random_state=2230021)

# モデル構築と学習

from sklearn.svm import LinearSVC # モジュールのインポート
# モデルの準備
model_LSVC = LinearSVC()
model_LSVC.fit(x_train, y_train) # 学習用のみを使用すること！

# 訓練データとテストデータに対する正解率を算出
score_train_LSVC = model_LSVC.score(x_train, y_train) #トレーニング用データ
score_test_LSVC = model_LSVC.score(x_test, y_test) #テストのデータ


# モデル名と正解率を出力
print(f"LinearSVCの訓練データの正解率は{score_train_LSVC}")
print(f"LinearSVCのテストデータの正解率は{score_test_LSVC}")


''' モデルの学習と構築2 KNeighbors'''

# モデルの構築と学習
from sklearn.neighbors import KNeighborsClassifier
 # モデルの作成
model_KN = KNeighborsClassifier()
# fitに学習用データを入れて学習
model_KN = model_KN.fit(x_train, y_train) # 学習用のみを使用すること！

# 訓練データとテストデータに対する正解率を算出
score_train_KN = model_KN.score(x_train, y_train) #トレーニング用データ
score_test_KN = model_KN.score(x_test, y_test) #テストのデータ

# 正解率を出力
print(f"KNeighborsの訓練データの正解率は{score_train_KN}")
print(f"KNeighborsのテストデータの正解率は{score_test_KN}")


''' モデルの学習と構築3 SVM '''

# モデルの構築と学習
from sklearn.svm import SVC
 # モデルの作成
model_SVC = SVC()
# fitに学習用データを入れて学習
model_SVC = model_SVC.fit(x_train, y_train) # 学習用のみを使用すること！

# 訓練データとテストデータに対する正解率を算出
score_train_SVC = model_SVC.score(x_train, y_train) #トレーニング用データ
score_test_SVC = model_SVC.score(x_test, y_test) #テストのデータ

# 正解率を出力
print(f"SVCの訓練データの正解率は{score_train_SVC}")
print(f"SVCのテストデータの正解率は{score_test_SVC}")





''' モデルの学習と構築4 RandomForest '''

# モデルの構築と学習
from sklearn.ensemble import RandomForestClassifier
 # モデルの作成
model_RFC = RandomForestClassifier()
# fitに学習用データを入れて学習
model_RFC = model_RFC.fit(x_train, y_train) # 学習用のみを使用すること！

# 訓練データとテストデータに対する正解率を算出
score_train_RFC = model_RFC.score(x_train, y_train) #トレーニング用データ
score_test_RFC = model_RFC.score(x_test, y_test) #テストのデータ

# 正解率を出力
print(f"RandomForestの訓練データの正解率は{score_train_RFC}")
print(f"RandomForestのテストデータの正解率は{score_test_RFC}")

''' モデルの学習と構築5 一番良かったモデル '''

model_best = model_RFC
test_score_best = score_test_RFC

# 正解率を出力
print(f"一番良かったモデルは{model_best}")
print(f"そのモデルの正解率は{score_test_RFC}")

