import java.util.Scanner;

public class JKad11B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("そうだ!水族館へ行こう!!");
        System.out.print("あなたの年齢を入力してください>");
        int a = sc.nextInt();
        if ( a >=65 ) {
            System.out.println("シニア料金:2200円になります!");
        }else if ( a >= 15 ) {
                System.out.println("大人料金:2400円になります!");
        }else if ( a >= 6 ) {
                System.out.println("子供料金:1200円になります!");
        }else if ( a >= 3 ) {
                System.out.println("幼児料金:600円になります!");
        }else{
            System.out.println("無料です!");
        }
    }
}
