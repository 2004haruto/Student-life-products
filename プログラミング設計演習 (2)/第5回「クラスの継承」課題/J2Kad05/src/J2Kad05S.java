/*
	課題名：J2Kad05S「ECCコーヒー！」
	作成日：2023/10/10
	作成者：田中太郎
*/
import java.util.Scanner;

public class J2Kad05S {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("ECCコーヒーへようこそ！");
        System.out.println("門外不出のレシピで作るから、おいしいよ！！");
        System.out.println();

        while (true) {
            System.out.print("ご注文は？（0：コーヒー、1；紅茶、2：ココア、3：ミルクティー、-1：店を出る）＞");
            int	n = in.nextInt();
            if (n < 0) break;

            switch (n) {
                default:
                case 0:
                    // コーヒーを作る
                    Coffee coffee = new Coffee();
                    coffee.boilWater();
                    coffee.dripCoffee();
                    coffee.pourInCup();
                    break;
                case 1:
                    // 紅茶を作る
                    Tea tea = new Tea();
                    tea.boilWater();
                    tea.steepTeabag();
                    tea.pourInCup();
                    break;
                case 2:
                    // ココアを作る



                    break;
                case 3:
                    // 紅茶を作る



                    break;
            }
            System.out.println("お待たせしました！ごゆっくりどうぞ！");
            System.out.println();
        }
        System.out.println("ありがとうございました！");
    }
}
