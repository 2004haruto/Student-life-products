import java.util.Scanner;

public class JKad12X {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("‚Ğ‚Æ‚Â‚ß‚Ì®”‚ğ“ü—Í‚µ‚Ä‚­‚¾‚³‚¢„");
        int a = in.nextInt();
        System.out.print("‚Ó‚½‚Â‚ß‚Ì®”‚ğ“ü—Í‚µ‚Ä‚­‚¾‚³‚¢„");
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
                System.out.println("Å‘åŒö–ñ”‚Í" + a + "‚Å‚·!");
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
                System.out.println("Å¬Œö”{”‚Í" + d + "‚Å‚·!");
                break;
            }
        }
        return c;
    }
}
