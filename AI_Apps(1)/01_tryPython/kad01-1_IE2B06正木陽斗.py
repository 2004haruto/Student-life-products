"""
キーボードから身長(cm)の入力を受け付け、
その人のBMIを算出して表示するプログラムを作成しなさい

BMI = 体重(kg) ÷ 身長(m) ÷ 身長(m)

【実行結果:168、60をキーボードから入力した場合】
身長(cm)を入力してください>>168
体重(kg)を入力してください>>60
あなたのBMIは17.857142857142858

[ヒント] キーボード入力を受け付けるにはinput関数を使用する
"""
# 最初にコメントでクラス番号氏名を書く
# 例：IE2A40 苗字名前

# IE2B06 正木陽斗

height1 = input("身長(cm)を入力してください>>")
weight = input("体重(kg)を入力してください>>")

# 身長と体重を数値に変換
height1 = int(height1)
weight = int(weight)

# 身長をメートルに変換
height2 = height1 / 100

# BMIを計算
BMI = weight / (height2 * height2)

# BMIを表示
print("あなたのBMIは " + str(BMI))
