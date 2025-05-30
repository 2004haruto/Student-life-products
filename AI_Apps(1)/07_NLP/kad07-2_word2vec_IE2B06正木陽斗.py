from gensim.models import word2vec
from janome.tokenizer import Tokenizer  # Janomeを使用

# JanomeのTokenizerを使って形態素解析を行う
tokenizer = Tokenizer()

# # 分かち書き済みの文書（学習用データ）を読み込む
# sentences = word2vec.Text8Corpus('./topic_wakati.txt')

# # Word2Vecモデルを学習（skip-gramモデル、ベクトルサイズ100、ウィンドウサイズ5、最小カウント5）
# model = word2vec.Word2Vec(sentences, sg=0, vector_size=100, window=5, min_count=5)

# # 学習したモデルを保存
# model.save("./topic.model")

# モデルをロードして利用
model = word2vec.Word2Vec.load("./wiki.model")

# 繰り返し入力できるように
while True:
    # 解析したい文をキーボードから入力
    s = input("解析したい文を入力してください>>")
    if s == "q": break

    # 入力した文を形態素解析する（Janomeで分かち書き）
    tokens = tokenizer.tokenize(s)

    # 類似度を計算したい言葉を変数に入れておく
    target = '至急'

    # Word2Vecモデルに'関連'が含まれているか確認
    # if target not in model.wv.key_to_index:
    #     print(f"モデルに'{target}'が存在しません。")
    #     continue

    # 単語リストに対して類似度計算
    found_related_word = False

    # print(tokens)

    for token in tokens:
        print("aa")
        # モデルに含まれていない単語をスキップ
        # if token not in model.wv.key_to_index:
        #     continue
        # print(token)
        part_of_speech = token.part_of_speech.split(',')[0]  # 品詞の取得
        print(part_of_speech)
        if part_of_speech in ['名詞', '動詞', '形容詞', '副詞']:
            # '関連'の類似度を計算する
            similarity = model.wv.similarity(target, token.surface)
            print(similarity)
            # 類似度が0.1以上なら関連する用語とみなす
            if similarity > 0.2:
                found_related_word = True
                break

    # 結果を出力
    if found_related_word:
        print(f"'{s}' には '{target}' と関連する用語が含まれます。")
    else:
        print(f"'{s}' には '{target}' と関連する用語は含まれていません。")
