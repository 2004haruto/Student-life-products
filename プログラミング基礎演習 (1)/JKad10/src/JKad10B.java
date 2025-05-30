import java.util.Scanner;

public class JKad10B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("‚»‚¤‚¾!…‘°ŠÙ‚És‚±‚¤!!");
        System.out.print("‚ ‚È‚½‚Ì”N—î‚ð“ü—Í‚µ‚Ä‚­‚¾‚³‚¢>");
        int a = sc.nextInt();
        if (a >= 3) {
            if (a >= 65) {
                System.out.println("ƒVƒjƒA—¿‹à:2200‰~‚É‚È‚è‚Ü‚·!");
            }
            if (a >= 15 && a < 65) {
                System.out.println("‘ål—¿‹à:2400‰~‚É‚È‚è‚Ü‚·!");
            }
            if (a >= 6 && a < 15) {
                System.out.println("Žq‹Ÿ—¿‹à:1200‰~‚É‚È‚è‚Ü‚·!");
            }
            if (a >= 3 && a < 6) {
                System.out.println("—cŽ™—¿‹à:600‰~‚É‚È‚è‚Ü‚·!");
            }
        } else {
            System.out.println("–³—¿‚Å‚·!");
        }
    }
}




