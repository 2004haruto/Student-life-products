import java.util.Scanner;

public class J2Kad24A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("世界にはばたくECCフーズ！");
        System.out.println("ただいまM&Aで拡大中！！");

        while (true) {
            System.out.print("どのメニューを表示しますか？（0：ECCコーヒー、1：ECCドーナツ、2：ECCバーガー、-1：終了）＞");
            int shop = Integer.parseInt(in.next());
            if (shop < 0) break;

            Menu menu;

            switch(shop) {
                default:
                case 0:
                    menu = new CafeMenu();
                    break;
                case 1:
                    menu = new DonutMenu();
                    break;
                case 2:
                    menu = new BurgerMenu();
                    break;
            }

            // 共通で同じ処理
            MenuIterator it = menu.iterator();
            while (it.hasNext()){
                it.next().print();
            }
            System.out.println();
        }
    }
}
