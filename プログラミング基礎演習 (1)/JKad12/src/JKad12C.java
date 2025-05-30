import java.util.Scanner;

public class JKad12C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("1‚æ‚è‘å‚«‚¢®”‚ð“ü—Í‚µ‚Ä‚­‚¾‚³‚¢>");
        int a = in.nextInt();
        int b = 1;
        int c  = 0;
        System.out.println("1‚©‚ç" + a + "‚Ü‚Å‰ÁŽZ‚µ‚Ü‚·!");
        while ( b <= a ) {
            c+=b;
            b++;
        }
        System.out.println("‡Œv‚Í" + c + "‚Å‚·!!");
    }
}
