import java.util.Scanner;

public class JKadC2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("そうだ!動物園へ行こう!!");
        System.out.print("あなたの年齢を入力してください>");
        int a = sc.nextInt();
        if ( a >=15 ) {
            System.out.println("大人料金:500円になります!");
        }else if ( a >=6 ) {
            if ( a < 15 ) {
                System.out.println("子供料金:200円になります!");
            }
        }else{
            System.out.println("無料です!");
        }

    }
}
