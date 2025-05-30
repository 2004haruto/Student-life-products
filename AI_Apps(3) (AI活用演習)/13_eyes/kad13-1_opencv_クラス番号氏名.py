import cv2

# Haar-cascade分類器のファイルを読み込む（目の検出用）
cascade_file = cv2.data.haarcascades + "haarcascade_frontalface_alt.xml"
eye_cascade_file = cv2.data.haarcascades + "haarcascade_eye.xml"

# 顔と目の検出器を作成
face_cascade = cv2.CascadeClassifier(cascade_file)
eye_cascade = cv2.CascadeClassifier(eye_cascade_file)

# カメラを開く
cap = cv2.VideoCapture(0)

if not cap.isOpened():
    print("カメラが開けませんでした。")
    exit()

while True:
    # フレームを取得
    ret, frame = cap.read()
    if not ret:
        print("フレームの読み取りに失敗しました。")
        break

    # 画像をグレースケールに変換（顔検出のため）
    gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)

    # 顔を検出
    faces = face_cascade.detectMultiScale(gray, scaleFactor=1.1, minNeighbors=5, minSize=(150, 150))

    # 顔が検出された場合、その顔に対して目の検出を行う
    for (x, y, w, h) in faces:
        # 顔の部分に対して目の検出を行う
        roi_gray = gray[y:y+h, x:x+w]
        eyes = eye_cascade.detectMultiScale(roi_gray)

        # 目の領域をリストに格納
        eye_coords = []

        # 検出された目をリストに追加
        for (ex, ey, ew, eh) in eyes:
            eye_coords.append((x + ex, y + ey, x + ex + ew, y + ey + eh))

        # 両目の最小の矩形を求める
        if len(eye_coords) >= 2:
            # 両目の最小x, 最大x, 最小y, 最大yを計算
            min_x = min(eye_coords, key=lambda c: c[0])[0]
            min_y = min(eye_coords, key=lambda c: c[1])[1]
            max_x = max(eye_coords, key=lambda c: c[2])[2]
            max_y = max(eye_coords, key=lambda c: c[3])[3]

            # 両目の領域を黒く塗りつぶす
            cv2.rectangle(frame, (min_x, min_y), (max_x, max_y), (0, 0, 0), -1)

    # フレームを表示
    cv2.imshow("Eye Detection", frame)

    # 'q'キーを押すと終了
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

# カメラを解放し、ウィンドウを閉じる
cap.release()
cv2.destroyAllWindows()
