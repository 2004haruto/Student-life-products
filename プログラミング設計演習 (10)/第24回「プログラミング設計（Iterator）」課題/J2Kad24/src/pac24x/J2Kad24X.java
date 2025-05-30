/*
	課題名：J2Kad24X「世界にはばたくECCフーズ！（拡張for文対応）」
	作成日：2023/1/11
	作成者：田中太郎
*/
package pac24x;

import java.util.Scanner;

public class J2Kad24X {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("世界にはばたくECCフーズ！");
        System.out.println("ただいまM&Aで拡大中！！");

        while (true) {
            System.out.print("どのメニューを表示しますか？（0：ECCコーヒー、1：ECCドーナツ、2：ECCバーガー、-1：終了）＞");
            int shop = Integer.parseInt(in.next());
            if (shop < 0) break;

            switch(shop) {
                default:
                case 0:     // ECCコーヒー
                    CafeMenu cafe = new CafeMenu();
                    MenuItem[] menu = cafe.getMenu();
                    for (int i = 0; menu[i] != null; i++) {
                        menu[i].print();
                    }
                    break;
                case 1:     // ECCドーナツ
                    DonutMenu donut = new DonutMenu();
                    String[] names = donut.getNames();
                    int[] prices = donut.getPrices();
                    for (int i = 0; prices[i] != -1; i++) {
                        MenuItem item = new MenuItem(names[i], prices[i]);
                        item.print();
                    }
                    break;
                case 2:     // ECCバーガー
                    BurgerMenu burger = new BurgerMenu();
                    for (var item : burger.getMenu()) {
                        item.print();
                    }
                    break;
            }
            System.out.println();
        }
    }
}
