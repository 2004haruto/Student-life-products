/*
	課題名：J2Kad24D「世界にはばたくECCフーズ！（ループの復習）」
	作成日：2023/1/11
	作成者：田中太郎
*/
import java.util.Scanner;

public class J2Kad24D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("世界にはばたくECCフーズ！");
        System.out.println("ただいまM&Aで拡大中！！");

        while (true) {
            System.out.print("どのメニューを表示しますか？（0：ECCコーヒー、1：ECCドーナツ、-1：終了）＞");
            int shop = Integer.parseInt(in.next());
            if (shop < 0) break;

            switch(shop) {
                default:
                case 0:     // ECCコーヒー全メニューの表示
                    CafeMenu cafeMenu = new CafeMenu();
                    MenuItem[] menu = cafeMenu.getMenu(); //メニューの代入
                    //for文で取り出す
                    for (int i = 0;menu[i] != null;i++){
                        menu[i].print();
                    }
                    break;
                case 1:     // ECCドーナツ全メニューの表示
                    DonutMenu dmenu = new DonutMenu();
                    String[] names = dmenu.getNames();
                    int[] prices = dmenu.getPrices();
                    for (int i = 0;prices[i] != -1;i++){
                        System.out.println(names[i]+":"+prices[i]);
                    }
                    break;
            }
            System.out.println();
        }
    }
}
