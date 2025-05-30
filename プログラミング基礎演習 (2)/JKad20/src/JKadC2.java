import java.util.Scanner;

public class JKadC2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("1 ‚æ‚è‘å‚«‚¢®”‚ğ“ü—Í‚µ‚Ä‚­‚¾‚³‚¢„");
        int a = in.nextInt();
        System.out.println("1‚©‚ç" + a + "‚Ü‚Å‰ÁZ‚µ‚Ü‚·!");
        int b;
        int c = 0;
        for (b = 1; b <= a; b++) {
            c+=b;
        }
        System.out.println("‡Œv‚Í" + c + "‚Å‚·!");
    }
}
