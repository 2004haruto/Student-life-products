import java.util.Scanner;

public class JKad12X {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("�ЂƂ߂̐�������͂��Ă���������");
        int a = in.nextInt();
        System.out.print("�ӂ��߂̐�������͂��Ă���������");
        int b = in.nextInt();
        calcGCD(a,b);
        calcLCM(a,b);
    }
    public static int calcGCD(int a, int b) {
        while (true) {
            if (a > b) {
                a -= b;
            } else if (b > a) {
                b -= a;
            } else {
                System.out.println("�ő���񐔂�" + a + "�ł�!");
                break;

            }
        }
        return a;
    }
    public static int calcLCM(int a, int b) {
        int c = a;
        int d = b;
        while (true) {
            if (c < d) {
                c += a;
            } else if (d < c) {
                d += b;
            } else {
                System.out.println("�ŏ����{����" + d + "�ł�!");
                break;
            }
        }
        return c;
    }
}
