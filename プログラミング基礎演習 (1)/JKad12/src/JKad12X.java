import java.util.Scanner;

public class JKad12X {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("ひとつめの整数を入力してください＞");
        int a = in.nextInt();
        System.out.print("ふたつめの整数を入力してください＞");
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
                System.out.println("最大公約数は" + a + "です!");
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
                System.out.println("最小公倍数は" + d + "です!");
                break;
            }
        }
        return c;
    }
}
