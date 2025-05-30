import java.util.Arrays;

public class Canvas {
    private boolean[][] pixel;
    public Canvas(int width, int height) {
        pixel = new boolean[height][width];
        clear();
    }
    public void clear() {
        for (boolean[] booleans : pixel) {
            Arrays.fill(booleans, false);
        }
    }
    public void show() {
        for (int y = 0; y < pixel.length; y++) {
            for (int x = 0; x < pixel[y].length; x++) {
                System.out.print((pixel[y][x])? "›": "E");
            }
            System.out.println();
        }
    }
    public boolean isInbound(int x, int y) {
        if ((y < 0)||(pixel.length <= y)) return false;
        if ((x < 0)||(pixel[y].length <= x)) return false;
        return true;
    }
    public void setPoint(int x, int y, boolean dot) {
        if (isInbound(x, y)) pixel[y][x] = dot;
    }
    public boolean getPoint(int x, int y) {
        return isInbound(x, y)? pixel[y][x] : false;
    }
}
