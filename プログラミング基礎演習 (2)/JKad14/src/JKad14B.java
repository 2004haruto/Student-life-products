import java.util.Scanner;

public class JKad14B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("‰~‚Ì–ÊÏ‚ğ‹‚ß‚Ü‚·I");
        System.out.print("”¼Œa‚Ì’·‚³‚ğ“ü—Í‚µ‚Ä‚­‚¾‚³‚¢„");
        int a = in.nextInt();
        System.out.print("’N‚ÉŒvZ‚³‚¹‚Ü‚·‚©Hi1F‚Ì‚Ñ‘¾A2Fo–Ø™j„");
        int b = in.nextInt();
        if ( b ==1 ) {
            nobita(a);
        }else if (b ==2) {
            dekisugi(a);
        }
    }
    public static void nobita(int a) {
        System.out.println("”¼Œa"+a+"‚Ì‰~‚Ì–ÊÏ‚Í"+a*a*3+"‚¾‚æ!");
    }
    public static void dekisugi(int a) {
        System.out.println("”¼Œa"+a+"‚Ì‰~‚Ì–ÊÏ‚Í"+a*a*3.14+"‚³!");
    }
}
