public class Point {
    public int x, y;
    public Point() {
        x = (int)(Math.random() * 50);
        y = (int)(Math.random() * 50);
    }
    public void printInfo() {
        System.out.printf("(%2d, %2d)\tx + y = %d\n", x, y, (x + y));
    }
}