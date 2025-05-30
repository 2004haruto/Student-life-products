# ライブラリのインポート
from ultralytics import YOLO

# ファイル名のリスト
files = ['bus.jpg', 'zidane.jpg', 'crossroad.jpg']
# バス画像を含むファイル名のリスト
bus_files = []

# モデルの準備
# モデルの読み込み
# model = YOLO("モデルファイルパス")
model = YOLO("yolo11n.pt")

# # バス画像を含むファイル名のリストを作る
# for file in files:
#     # 画像をモデルに渡して推論を実行
#     results = model(file)

#     # 各推論結果を解析
#     for result in results:
#         # 検出されたクラス番号を取得（整数のリスト）
#         detected_classes = result.boxes.cls.tolist() if result.boxes else []

#         # クラス名を取得
#         detected_class_names = [result.names[int(cls)] for cls in detected_classes]

#         # "bus" が含まれているか確認
#         if "bus" in detected_class_names:
#             bus_files.append(file)
#             break

results = model.predict(files)

for result in results:
    for object in result.summary():
        if object["name"] == "bus":
            bus_files.append(result.path)
            break

# 結果の表示
print(bus_files)