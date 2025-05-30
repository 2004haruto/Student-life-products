import cv2

def blackout(img, rect):
    # rect: (x1, y1, x2, y2)
    # 矩形領域を黒く塗りつぶす
    (x1, y1, x2, y2) = rect
    img2 = img.copy()  # 元画像をコピー
    img2[y1:y2, x1:x2] = (0, 0, 0)  # 黒色 (BGRで全て0)
    return img2
