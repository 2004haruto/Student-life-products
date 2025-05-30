import java.util.Scanner;

public class JKad15B1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("1 ‚æ‚è‘å‚«‚¢®”‚ğ“ü—Í‚µ‚Ä‚­‚¾‚³‚¢„");
        int a = in.nextInt();
        System.out.println("1‚©‚ç"+ a + "‚Ü‚Å‰ÁZ‚µ‚Ü‚· !");
        int d= integrate(a);
        System.out.println("‡Œv‚Í" + d +"‚Å‚·!!");
    }
    public static int integrate(int a) {
        int b = 0;
        int c  = 0;
        while ( a<=1 ) ;
        while (b<a) {
            b++;
            c += b;

        }
        return c;
    }
}
