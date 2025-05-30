# pandasライブラリのインポート
import pandas as pd

# iris-dataset.csvファイルを読み込み、データフレームに変換する
df = pd.read_csv('iris-dataset.csv')
# データの行数を確認
print(df.head(5))
# 特微量を抽出して変数xに代入
x = df[['がく片長さ', 'がく片幅', '花弁長さ', '花弁幅']]
# 正解データを抽出して変数tに代入
t = df['種類']

# データセットを学習用とテスト用に分割
# 関数のインポート
# 関数を使うためにインポート
from sklearn.model_selection import train_test_split

# データの分割
x_train, x_test, y_train, y_test = train_test_split(
	x, 
	t,  
	test_size=0.3, 
	random_state=2230021,
	stratify=t,  # 各クラスのデータの割合を保って分割する
)


''' モデルの学習と構築1 LinearSVC '''

# モデル構築と学習
from sklearn.svm import LinearSVC # モジュールのインポート
 # モデルの作成
model_LSVC = LinearSVC()
# fitに学習用データを入れて学習
model_LSVC.fit(x_train, y_train) # 学習用のみを使用すること！

# 訓練データとテストデータに対する正解率を算出
score_train = model_LSVC.score(x_train, y_train) #トレーニング用データ
score_test = model_LSVC.score(x_test, y_test) #テストのデータ

# 正解率を出力
print(score_train)
print(score_test)



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
print(score_train_KN)
print(score_test_KN)

''' モデルの学習と構築3 SVC '''

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
print(score_train_SVC)
print(score_test_SVC)


''' モデルの学習と構築4 RandomForest'''

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
print(score_train_RFC)
print(score_test_RFC)

