import java.util.Scanner;

public class JKad11B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("‚»‚¤‚¾!…‘°ŠÙ‚Ös‚±‚¤!!");
        System.out.print("‚ ‚È‚½‚Ì”N—î‚ð“ü—Í‚µ‚Ä‚­‚¾‚³‚¢>");
        int a = sc.nextInt();
        if ( a >=65 ) {
            System.out.println("ƒVƒjƒA—¿‹à:2200‰~‚É‚È‚è‚Ü‚·!");
        }else if ( a >= 15 ) {
                System.out.println("‘ål—¿‹à:2400‰~‚É‚È‚è‚Ü‚·!");
        }else if ( a >= 6 ) {
                System.out.println("Žq‹Ÿ—¿‹à:1200‰~‚É‚È‚è‚Ü‚·!");
        }else if ( a >= 3 ) {
                System.out.println("—cŽ™—¿‹à:600‰~‚É‚È‚è‚Ü‚·!");
        }else{
            System.out.println("–³—¿‚Å‚·!");
        }
    }
}
