import java.util.Scanner;

public class JKad11C2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("‚»‚¤‚¾!“®•¨‰€‚Ös‚±‚¤!!");
        System.out.print("‚ ‚È‚½‚Ì”N—î‚ð“ü—Í‚µ‚Ä‚­‚¾‚³‚¢>");
        int a = sc.nextInt();
        if ( a >=15 ) {
            System.out.println("‘ål—¿‹à:500‰~‚É‚È‚è‚Ü‚·!");
        }else if ( a >=6 ) {
            if ( a < 15 ) {
                System.out.println("Žq‹Ÿ—¿‹à:200‰~‚É‚È‚è‚Ü‚·!");
            }
        }else{
            System.out.println("–³—¿‚Å‚·!");
        }

    }
}

