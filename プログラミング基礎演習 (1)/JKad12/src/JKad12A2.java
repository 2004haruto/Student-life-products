import java.util.Scanner;

public class JKad12A2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("‚Ð‚Æ‚Â‚ß‚Ì®”‚ð“ü—Í‚µ‚Ä‚­‚¾‚³‚¢>");
        int a = in.nextInt();
        System.out.print("‚Ó‚½‚Â‚ß‚Ì®”‚ð“ü—Í‚µ‚Ä‚­‚¾‚³‚¢>");
        int b = in.nextInt();
        int c = a;
        int d = b;
        while (true){
            if(c < d) {
                c += a;
            }else if (d <c) {
                d += b;
            }else{
                System.out.println("Å¬Œö”{”‚Í"+d+"‚Å‚·!");
                break;
            }
        }
    }
}
