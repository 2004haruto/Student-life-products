import java.util.Scanner;

public class JKad10D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("そうだ!動物園に行こう!!");
        System.out.print("あなたの年齢を入力してください>");
        int a = sc.nextInt();
        if (a >=15) {
            System.out.println("大人料金:500円になります!");
        }
            if (a >=6 && a<15) {
                System.out.println("子供料金:200円になります!");
            }
                if (a<6) {
                    System.out.println("無料です!");
                }
            }
        }



