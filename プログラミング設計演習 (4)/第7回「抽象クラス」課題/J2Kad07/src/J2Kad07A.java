import java.util.Scanner;

public class J2Kad07A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("ECCコーヒーへようこそ！");
        System.out.println("門外不出のレシピで作るから、おいしいよ！！");
        System.out.println();

        while (true) {
            System.out.print("ご注文は？（0：コーヒー、1；紅茶、2：ココア、-1：店を出る）＞");
            int    n = in.nextInt();
            if (n < 0) break;
            HotDrink a;
            switch (n) {
                default:
                case 0: // コーヒーを作る
                    a = new Coffee();
                    break;
                case 1: // 紅茶を作る
                    a = new Tea();
                    break;
                case 2:
                    a =new Cocoa();
                    break;

            }
            a.execute();
            System.out.println("お待たせしました！ごゆっくりどうぞ！");
            System.out.println();
        }

        System.out.println("ありがとうございました！");
    }
}