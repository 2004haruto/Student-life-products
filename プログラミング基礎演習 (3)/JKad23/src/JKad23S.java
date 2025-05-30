import java.util.Scanner;

public class JKad23S {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("uŒv‚ğ“ü—Í‚µ‚Ä‚­‚¾‚³‚¢>");
        int a = in.nextInt();
        System.out.print("u“úv‚ğ“ü—Í‚µ‚Ä‚­‚¾‚³‚¢„");
        int b = in.nextInt();
        int c = a % b;
        switch (c){
            case 1:
                System.out.println(a+"Œ"+b+"“ú‚Í“ú—j“ú‚Å‚·!");
                break;
            case 2:
                System.out.println(a+"Œ"+b+"“ú‚ÍŒ—j“ú‚Å‚·!");
                break;
            case 3:
                System.out.println(a+"Œ"+b+"“ú‚Í‰Î—j“ú‚Å‚·!");
                break;
            case 4:
                System.out.println(a+"Œ"+b+"“ú‚Í…—j“ú‚Å‚·!");
                break;
            case 5:
                System.out.println(a+"Œ"+b+"“ú‚Í–Ø—j“ú‚Å‚·!");
                break;
            case 6:
                System.out.println(a+"Œ"+b+"“ú‚Í‹à—j“ú‚Å‚·!");
                break;
            case 7:
                System.out.println(a+"Œ"+b+"“ú‚Í“y—j“ú‚Å‚·!");
                break;
        }
    }
}
