public class Canvas {
    public static final int WIDTH = 40;
    public static final int HEIGHT = 16;
    private boolean[][] pixel;
    private int cx, cy;                 // フォント描画用カーソル
    public Canvas() {
        pixel = new boolean[HEIGHT][WIDTH];
        clear();
    }
    public void clear() {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                pixel[y][x] = false;
            }
        }
        cx = 0;
        cy = 0;
    }
    public void show() {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                System.out.print((pixel[y][x])? "○": "・");
            }
            System.out.println();
        }
    }
    public void setPoint(int x, int y, boolean dot) {
        if ((y < 0)||(HEIGHT <= y)) return;
        if ((x < 0)||(WIDTH <= x)) return;
        pixel[y][x] = dot;
    }
    public void drawFont(boolean[][] fontdata) {
        // 改行チェック
        if (WIDTH < (cx + fontdata[0].length)) {
            cy += fontdata.length;      // CR
            cx = 0;                     // LF
        }
        // 描画
        for (int y = 0; y < fontdata.length; y++) {
            for (int x = 0; x < fontdata[y].length; x++ ) {
                setPoint(cx + x, cy + y, fontdata[y][x]);
            }
        }
        // カーソル進める
        cx += fontdata[0].length;
    }
}
