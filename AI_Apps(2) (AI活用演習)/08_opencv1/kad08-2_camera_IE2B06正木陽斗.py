import cv2

# カメラをキャプチャ
cap = cv2.VideoCapture(0)

# 動画の幅と高さを取得
frame_width = int(cap.get(cv2.CAP_PROP_FRAME_WIDTH))
frame_height = int(cap.get(cv2.CAP_PROP_FRAME_HEIGHT))
fps = int(cap.get(cv2.CAP_PROP_FPS))

# 動画保存の設定（出力ファイル名、コーデック、FPS、フレームサイズ）
output_filename = "kad08-2.mp4"
fourcc = cv2.VideoWriter_fourcc(*'MP4V')  
out = cv2.VideoWriter(output_filename, fourcc, fps, (frame_width, frame_height), isColor=False)

# エッジ検出の閾値
threshold1 = 100
threshold2 = 200

# フレームを逐次取得してエッジ検出を行い保存
while cap.isOpened():
    ret, frame = cap.read()
    if not ret:
        break
    
    # エッジ検出
    frame_edge = cv2.Canny(frame, threshold1, threshold2)

    # エッジ検出結果を保存
    out.write(frame_edge)
    
    # 表示（オプション）
    cv2.imshow('Edge Detection', frame_edge)
    
    # 'q'キーで終了
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

# リソース解放
cap.release()
out.release()
cv2.destroyAllWindows()
