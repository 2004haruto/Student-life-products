import java.util.Scanner;

public class JKad10A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("そうだ!動物園に行こう!");
        System.out.print("何人で行きますか?>");
        int a = sc.nextInt();
        System.out.print("あなたの年齢を入力してください>");
        int b = sc.nextInt();
        if (b>=15) {
            if (a < 30) {
                System.out.println("大人料金:500円になります!");
            }
            if (a >= 30 && a < 50) {
                System.out.println("大人料金:450円になります!");
            }
            if (a >= 50) {
                System.out.println("大人料金:400円になります!");
            }
        }
        if (b >=6 && b<15) {
            if (a < 30) {
                System.out.println("子供料金:200円になります!");
            }
            if (a >= 30 && a < 50) {
                System.out.println("子供料金:180円になります!");
            }
            if (a >= 50) {
                System.out.println("子供料金:160円になります!");
            }
        }
        if (b <6) {
            System.out.println("無料です!");
            }
        }
    }



