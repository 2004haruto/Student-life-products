import java.util.Scanner;

public class JKad11A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("そうだ!動物園へ行こう!!");
        System.out.print("何人で行きますか?>");
        int a = sc.nextInt();
        System.out.print("あなたの年齢を入力してください>");
        int b = sc.nextInt();
        if (a >= 1) {
            if (a < 30) {
                if (b >= 15) {
                    System.out.println("大人料金:500円になります!");
                } else if (b >= 6) {
                        System.out.println("子供料金:200円になります!");
                } else {
                    System.out.println("無料です!");
                }
            }
             else if (a < 50) {
                    if (b >= 15) {
                        System.out.println("大人料金:450円になります!");
                    } else if (b >= 6) {
                            System.out.println("子供料金:180円になります!");
                    } else {
                        System.out.println("無料です!");
                    }
                }
                else if (b >= 15) {
                        System.out.println("大人料金:400円になります!");
                    } else if (b >= 6) {
                            System.out.println("子供料金:160円になります!");
                    } else {
                        System.out.println("無料です!");
                    }
                }
            }
        }


