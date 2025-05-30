import java.util.Scanner;

public class JKad10A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("‚»‚¤‚¾!“®•¨‰€‚És‚±‚¤!");
        System.out.print("‰½l‚Ås‚«‚Ü‚·‚©?>");
        int a = sc.nextInt();
        System.out.print("‚ ‚È‚½‚Ì”N—î‚ð“ü—Í‚µ‚Ä‚­‚¾‚³‚¢>");
        int b = sc.nextInt();
        if (b>=15) {
            if (a < 30) {
                System.out.println("‘ål—¿‹à:500‰~‚É‚È‚è‚Ü‚·!");
            }
            if (a >= 30 && a < 50) {
                System.out.println("‘ål—¿‹à:450‰~‚É‚È‚è‚Ü‚·!");
            }
            if (a >= 50) {
                System.out.println("‘ål—¿‹à:400‰~‚É‚È‚è‚Ü‚·!");
            }
        }
        if (b >=6 && b<15) {
            if (a < 30) {
                System.out.println("Žq‹Ÿ—¿‹à:200‰~‚É‚È‚è‚Ü‚·!");
            }
            if (a >= 30 && a < 50) {
                System.out.println("Žq‹Ÿ—¿‹à:180‰~‚É‚È‚è‚Ü‚·!");
            }
            if (a >= 50) {
                System.out.println("Žq‹Ÿ—¿‹à:160‰~‚É‚È‚è‚Ü‚·!");
            }
        }
        if (b <6) {
            System.out.println("–³—¿‚Å‚·!");
            }
        }
    }



