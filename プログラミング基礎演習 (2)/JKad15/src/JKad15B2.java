import java.util.Scanner;

public class JKad15B2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("1 ‚æ‚è‘å‚«‚¢®”‚ğ“ü—Í‚µ‚Ä‚­‚¾‚³‚¢„");
        int a = in.nextInt();
        System.out.println("1‚©‚ç"+ a + "‚Ü‚Å‰ÁZ‚µ‚Ü‚· !");
        int b= integrate(a);
        System.out.println("‡Œv‚Í" + b +"‚Å‚·!!");
    }
    public static int integrate(int a) {
        int c;
        if (a == 1) {
            return 1;
        } else {
            c = integrate( a- 1);

        }

        return a + c;
    }
}
