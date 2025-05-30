# データの読み込み
import pandas as pd
df = pd.read_csv('wine3class.csv')

# 特徴量とターゲットに分割
X = df.drop(columns=['class'])
y = df['class']

# データの分割
from sklearn.model_selection import train_test_split
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.3, random_state=2230033)

# モデル1: LinearSVC
from sklearn.svm import LinearSVC

# モデルの準備
model_LSVC = LinearSVC(max_iter=500000)
model_LSVC.fit(X_train, y_train)

# 訓練データとテストデータに対する正解率を算出
score_train_LSVC = model_LSVC.score(X_train, y_train)
score_test_LSVC = model_LSVC.score(X_test, y_test)  

# モデル名と正解率を出力
print("LinearSVCの訓練データの正解率は", score_train_LSVC)
print("LinearSVCのテストデータの正解率は", score_test_LSVC)

# モデル2: KNeighborsClassifier
from sklearn.neighbors import KNeighborsClassifier

# モデルの準備
model_KN = KNeighborsClassifier()
model_KN.fit(X_train, y_train)

# 訓練データとテストデータに対する正解率を算出
score_train_KN = model_KN.score(X_train, y_train)
score_test_KN = model_KN.score(X_test, y_test)  

# モデル名と正解率を出力
print("KNeighborsの訓練データの正解率は", score_train_KN)
print("KNeighborsのテストデータの正解率は", score_test_KN)

# モデル3: SVC
from sklearn.svm import SVC

# モデルの準備
model_SVC = SVC()
model_SVC.fit(X_train, y_train)

# 訓練データとテストデータに対する正解率を算出
score_train_SVC = model_SVC.score(X_train, y_train)
score_test_SVC = model_SVC.score(X_test, y_test)  

# モデル名と正解率を出力
print("SVCの訓練データの正解率は", score_train_SVC)
print("SVCのテストデータの正解率は", score_test_SVC)

# モデル4: RandomForestClassifier
from sklearn.ensemble import RandomForestClassifier

# モデルの準備
model_RFC = RandomForestClassifier()
model_RFC.fit(X_train, y_train)

# 訓練データとテストデータに対する正解率を算出
score_train_RFC = model_RFC.score(X_train, y_train)
score_test_RFC = model_RFC.score(X_test, y_test) 

# モデル名と正解率を出力
print("RandomForestの訓練データの正解率は", score_train_RFC)
print("RandomForestのテストデータの正解率は", score_test_RFC)

# 使用に適しているのは、RF