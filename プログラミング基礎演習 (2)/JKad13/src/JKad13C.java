import java.util.Scanner;

public class JKad13C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a ;
        int b = 0;
        int c  = 0;

        do {
            System.out.print("1 ‚æ‚è‘å‚«‚¢®”‚ð“ü—Í‚µ‚Ä‚­‚¾‚³‚¢>");
            a=in.nextInt();

        }while ( a<=1 ) ;
         while (b<a) {
             b++;
             c += b;

         }
        System.out.println("1‚©‚ç"+ a + "‚Ü‚Å‰ÁŽZ‚µ‚Ü‚· !");
        System.out.println("‡Œv‚Í" + c + "‚Å‚·!!");
    }
}


