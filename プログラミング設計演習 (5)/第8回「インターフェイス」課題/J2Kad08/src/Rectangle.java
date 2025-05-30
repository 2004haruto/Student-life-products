public class Rectangle implements IShape{
    private int[] x = new int[4];
    private int[] y = new int[4];

    public Rectangle(int left, int top, int width, int height) {
        x[0] = left;            y[0] = top;
        x[1] = left + width;    y[1] = top;
        x[2] = left + width;    y[2] = top + height;
        x[3] = left;            y[3] = top + height;
    }
    public void draw(Canvas c) {
        for (int i = 0; i < 4; i++) {
            c.drawLine(x[i], y[i], x[(i + 1) % 4], y[(i + 1) % 4]);
        }
    }
}