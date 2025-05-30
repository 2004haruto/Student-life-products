import java.util.Scanner;

public class J2Kad08A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Canvas    c = new Canvas(40, 25);

        while(true) {
            System.out.print("何を描画しますか？（0：三角形、1：長方形、2：消去、3:正方形、-1：終了）＞");
            int    n = in.nextInt();
            if (n < 0) break;
            IShape a;
            // ↓簡略化すること
            switch(n) {
                default:
                case 0:
                    a= new Triangle(1, 22, 18, 9);
                    break;
                case 1:
                    a = new Rectangle(12, 5, 20, 14);
                    break;
                case 2:
                    a= new Eraser();
                    break;
                case 3:
                    a=new Square(1,1,16);
                    break;

            }
            a.draw(c);
            c.show();
        }
    }
}