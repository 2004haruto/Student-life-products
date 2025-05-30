import java.util.Scanner;

public class JKad09D1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("‚Ğ‚Æ‚Â‚ß‚Ì®”‚ğ“ü—Í‚µ‚Ä‚­‚¾‚³‚¢„");
        int a = sc.nextInt();
        System.out.print("‚Ó‚½‚Â‚ß‚Ì®”‚ğ“ü—Í‚µ‚Ä‚­‚¾‚³‚¢„");
        int b = sc.nextInt();
        if (a < b) {
            System.out.println("‚Ó‚½‚Â‚Ì”š‚Å‘å‚«‚¢‚Ù‚¤‚Í" + b + "‚Å‚·I");
        } else {

            System.out.println("‚Ó‚½‚Â‚Ì”š‚Å‘å‚«‚¢‚Ù‚¤‚Í" + a + "‚Å‚·I");

        }
    }
}
