from transformers import pipeline

# 感情分析用のパイプラインを作成
model = pipeline("sentiment-analysis", model="koheiduck/bert-japanese-finetuned-sentiment")

# 繰り返し入力できるように
while True:
    # 解析したい文をキーボードから入力
    s = input(">> ")
    
    # 入力が空であれば終了
    if s == "":
        break

    # 感情分析の実行
    result = model(s)
    
    # 結果の表示（ラベルとスコアを含めて表示）
    print(result)
    
    # 結果によって返信を分ける
    sentiment = result[0]['label']
    
    # 感情ラベルに基づいて返信
    if sentiment == 'POSITIVE':
        print("良かったですね。")
    elif sentiment == 'NEGATIVE':
        print("つらいですね。")
    elif sentiment == 'NEUTRAL':
        print("なるほど。")
    else:
        print("わかりました。")
