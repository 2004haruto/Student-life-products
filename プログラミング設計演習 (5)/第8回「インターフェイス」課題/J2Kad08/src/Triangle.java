public class Triangle implements IShape {
    private int[] x = new int[3];
    private int[] y = new int[3];

    public Triangle(int left, int bottom, int width, int height) {
        x[0] = left;                y[0] = bottom;
        x[1] = left + width;        y[1] = bottom;
        x[2] = left + width / 2;    y[2] = bottom - height;
    }

    public void draw(Canvas c) {
        for (int i = 0; i < 3; i++) {
            c.drawLine(x[i], y[i], x[(i + 1) % 3], y[(i + 1) % 3]);
        }
    }
}