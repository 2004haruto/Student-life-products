import java.util.Scanner;

public class JKad11A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("‚»‚¤‚¾!“®•¨‰€‚Ös‚±‚¤!!");
        System.out.print("‰½l‚Ås‚«‚Ü‚·‚©?>");
        int a = sc.nextInt();
        System.out.print("‚ ‚È‚½‚Ì”N—î‚ð“ü—Í‚µ‚Ä‚­‚¾‚³‚¢>");
        int b = sc.nextInt();
        if (a >= 1) {
            if (a < 30) {
                if (b >= 15) {
                    System.out.println("‘ål—¿‹à:500‰~‚É‚È‚è‚Ü‚·!");
                } else if (b >= 6) {
                        System.out.println("Žq‹Ÿ—¿‹à:200‰~‚É‚È‚è‚Ü‚·!");
                } else {
                    System.out.println("–³—¿‚Å‚·!");
                }
            }
             else if (a < 50) {
                    if (b >= 15) {
                        System.out.println("‘ål—¿‹à:450‰~‚É‚È‚è‚Ü‚·!");
                    } else if (b >= 6) {
                            System.out.println("Žq‹Ÿ—¿‹à:180‰~‚É‚È‚è‚Ü‚·!");
                    } else {
                        System.out.println("–³—¿‚Å‚·!");
                    }
                }
                else if (b >= 15) {
                        System.out.println("‘ål—¿‹à:400‰~‚É‚È‚è‚Ü‚·!");
                    } else if (b >= 6) {
                            System.out.println("Žq‹Ÿ—¿‹à:160‰~‚É‚È‚è‚Ü‚·!");
                    } else {
                        System.out.println("–³—¿‚Å‚·!");
                    }
                }
            }
        }


