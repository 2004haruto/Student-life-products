import java.util.Scanner;

public class JKad13A {

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            System.out.println("数当てゲーム!");
            int a = 0;
            int b;
            int MIN = 0;
            int MAX = 99;
            int random = (int)(Math.random()*100);
            while (true){
                a++;
                do {
                    System.out.print(a + "回目:" + MIN + "から" + MAX + "までの数値を入力してください>");
                     b = in.nextInt();
                }while (b >=MAX || b <= MIN);
                if(random < b) {
                    MAX = b;
                    System.out.println(b + "より小さいです!");
                }else if(random>b) {
                    MIN = b ;
                    System.out.println(b + "より大きいです!");
                }else if (random == b) {
                    System.out.println("正解しました!");
                    break;
                }
            }
        }

    }
