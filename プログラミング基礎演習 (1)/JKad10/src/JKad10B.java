import java.util.Scanner;

public class JKad10B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("そうだ!水族館に行こう!!");
        System.out.print("あなたの年齢を入力してください>");
        int a = sc.nextInt();
        if (a >= 3) {
            if (a >= 65) {
                System.out.println("シニア料金:2200円になります!");
            }
            if (a >= 15 && a < 65) {
                System.out.println("大人料金:2400円になります!");
            }
            if (a >= 6 && a < 15) {
                System.out.println("子供料金:1200円になります!");
            }
            if (a >= 3 && a < 6) {
                System.out.println("幼児料金:600円になります!");
            }
        } else {
            System.out.println("無料です!");
        }
    }
}




