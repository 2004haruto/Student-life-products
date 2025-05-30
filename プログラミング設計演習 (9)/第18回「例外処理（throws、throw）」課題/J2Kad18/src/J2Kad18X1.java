/*
	課題名：J2Kad18X1「新装開店！ECCコーヒー①」
	作成日：2023/11/30
	作成者：田中太郎
*/
import java.util.Scanner;

public class J2Kad18X1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("ECCコーヒーへようこそ！");

        while(true) {
            // コーヒーの選択
            System.out.print("飲み物を選んでください（0：ブレンド、1：エスプレッソ、2：深煎りコーヒー、-1：店を出る）＞");
            int drink = Integer.parseInt(in.next());
            if (drink < 0) break;
            // トッピングの追加
            System.out.print("トッピングはどうしますか？（0：豆乳、1：ホイップ、2：ココア、-1：いらない）＞");
            int topping = Integer.parseInt(in.next());
            // ドリンクの生成
            MenuItem item = null;
            switch(drink) {
                default:
                case 0:     // ブレンドコーヒー
                    switch(topping) {
                        default:    item = new HouseBlend();        break;
                        case 0:     item = new HouseBlendSoy();     break;
                        case 1:     item = new HouseBlendWhip();    break;
                        case 2:     item = new HouseBlendCocoa();   break;
                    }
                    break;
                case 1:     // エスプレッソ
                    switch(topping) {
                        default:    item = new Espresso();          break;
                        case 0:     item = new EspressoSoy();       break;
                        case 1:     item = new EspressoWhip();      break;
                        case 2:     item = new EspressoCocoa();     break;
                    }
                    break;
                case 2:     // 深煎りコーヒー
                    switch(topping) {
                        default:    item = new DarkRoast();         break;
                        case 0:     item = new DarkRoastSoy();      break;
                        case 1:     item = new DarkRoastWhip();     break;
                        case 2:     item = new DarkRoastCocoa();    break;
                    }
                    break;
            }
            // 会計
            System.out.println("お待たせしました！");
            System.out.println(item.getName() + "です！");
            System.out.println(item.getPrice() + "円になります！");
            System.out.println();
        }
        System.out.println("ありがとうございました！");
    }
}

