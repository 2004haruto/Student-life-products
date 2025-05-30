import java.util.Scanner;

public class JKad12A1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("‚Ğ‚Æ‚Â‚ß‚Ì®”‚ğ“ü—Í‚µ‚Ä‚­‚¾‚³‚¢>");
        int a = in.nextInt();
        System.out.print("‚Ó‚½‚Â‚ß‚Ì®”‚ğ“ü—Í‚µ‚Ä‚­‚¾‚³‚¢>");
        int b = in.nextInt();
        while (true){
            if(a>b) {
                a -= b;
            }else if (b>a){
                b -= a;
            }else{
                System.out.println("Å‘åŒö–ñ”‚Í"+a+"‚Å‚·!");
                break;

            }
        }
    }
}
