# ライブラリのインポート
# JanomeのTokenizerインポート
from janome.tokenizer import Tokenizer

# Tokenizerオブジェクトの作成
t = Tokenizer()

# キーボードから日本語の文を入力
text = input("形態素解析をしたい文を入力>>")

# 保存するためのリストの作成
list_s = []
list_p = []

# 形態素解析の実行
for token in t.tokenize(text):
    # 表層系をリストに追加
    list_s.append(token.surface)
    
    # 名詞、動詞、形容詞の基本形のみをリストに追加
    part_of_speech = token.part_of_speech.split(',')[0]  # 品詞の取得
    if part_of_speech in ['名詞', '動詞', '形容詞']:
        list_p.append(token.base_form)
        
# リストの表示
print(f"すべての表層系：{list_s}")
print(f"名詞・動詞・形容詞の基本形のみ：{list_p}")
