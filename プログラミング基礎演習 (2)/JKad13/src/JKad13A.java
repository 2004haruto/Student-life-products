import java.util.Scanner;

public class JKad13A {

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            System.out.println("”“–‚ÄƒQ[ƒ€!");
            int a = 0;
            int b;
            int MIN = 0;
            int MAX = 99;
            int random = (int)(Math.random()*100);
            while (true){
                a++;
                do {
                    System.out.print(a + "‰ñ–Ú:" + MIN + "‚©‚ç" + MAX + "‚Ü‚Å‚Ì”’l‚ğ“ü—Í‚µ‚Ä‚­‚¾‚³‚¢>");
                     b = in.nextInt();
                }while (b >=MAX || b <= MIN);
                if(random < b) {
                    MAX = b;
                    System.out.println(b + "‚æ‚è¬‚³‚¢‚Å‚·!");
                }else if(random>b) {
                    MIN = b ;
                    System.out.println(b + "‚æ‚è‘å‚«‚¢‚Å‚·!");
                }else if (random == b) {
                    System.out.println("³‰ğ‚µ‚Ü‚µ‚½!");
                    break;
                }
            }
        }

    }
