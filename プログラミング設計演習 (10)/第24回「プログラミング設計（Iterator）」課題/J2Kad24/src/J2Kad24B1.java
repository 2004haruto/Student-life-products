/*
	課題名：J2Kad24D「世界にはばたくECCフーズ！（ループの復習）」
	作成日：2023/1/11
	作成者：田中太郎
*/
import java.util.Scanner;

public class J2Kad24B1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("世界にはばたくECCフーズ！");
        System.out.println("ただいまM&Aで拡大中！！");

        while (true) {
            System.out.print("どのメニューを表示しますか？（0：ECCコーヒー、1：ECCドーナツ、-1：終了）＞");
            int shop = Integer.parseInt(in.next());
            if (shop < 0) break;

            MenuIterator iterator ; //共通のイテレーター
            switch(shop) {
                default:
                case 0:     // ECCコーヒー全メニューの表示
                    CafeMenu cafeMenu = new CafeMenu();
                    iterator = new CafeIterator(cafeMenu.getMenu());
                    break;
                case 1:     // ECCドーナツ全メニューの表示
                    DonutMenu dMenu = new DonutMenu();
                    iterator = new DonutIterator(dMenu.getNames(),dMenu.getPrices());
                    break;
            }
            //共通で同じ処理
            while (iterator.hasNext()){
                iterator.next().print();
            }
            System.out.println();
        }
    }
}
