import java.util.Scanner;

public class J2Kad08A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Canvas    c = new Canvas(40, 25);

        while(true) {
            System.out.print("����`�悵�܂����H�i0�F�O�p�`�A1�F�����`�A2�F�����A3:�����`�A-1�F�I���j��");
            int    n = in.nextInt();
            if (n < 0) break;
            IShape a;
            // ���ȗ������邱��
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