public class Canvas {
    private boolean[][] pixel;

    public Canvas(int width, int height) {
        pixel = new boolean[height][width];
        for (int y = 0; y < pixel.length; y++) {
            for (int x = 0; x < pixel[y].length; x++) {
                pixel[y][x] = false;
            }
        }
    }
    public int getWidth() { return pixel[0].length; }
    public int getHeight() { return pixel.length; }
    public void show() {
        for (int y = 0; y < pixel.length; y++) {
            for (int x = 0; x < pixel[y].length; x++) {
                System.out.print("　" + ((pixel[y][x])? "○": "・"));
            }
            System.out.println();
        }
    }
    private boolean inBound(int x, int y) {
        if ((y < 0) || (pixel.length <= y)) return false;
        if ((x < 0) || (pixel[y].length <= x)) return false;
        return true;
    }
    public void set(int x, int y) {
        if (inBound(x, y)) pixel[y][x] = true;
    }
    public void reset(int x, int y) {
        if (inBound(x, y)) pixel[y][x] = false;
    }
    public void drawLine(int x1, int y1, int x2, int y2) {
        // ブレゼンハム（Bresenham）のアルゴリズム
        int	dx = ( x2 - x1 ) * 2;
        int	sx = 1;
        if ( dx < 0 ) {
            dx = -dx;
            sx = -sx;
        }

        int	dy = ( y2 - y1 ) * 2;
        int	sy = 1;
        if ( dy < 0 ) {
            dy = -dy;
            sy = -sy;
        }

        int		x = x1;
        int		y = y1;
        int		f;

        set( x, y );

        if ( dx > dy ) {
            f = dy * 2 - dx;
            while ( x != x2 ) {
                if ( f >= 0 ) {
                    y += sy;
                    f -= dx;
                }
                x += sx;
                f += dy;
                set( x, y );
            }
        }
        else {
            f = dx * 2 - dy;
            while ( y != y2 ) {
                if ( f >= 0 ) {
                    x += sx;
                    f -= dy;
                }
                y += sy;
                f += dx;
                set( x, y );
            }
        }
    }
}
