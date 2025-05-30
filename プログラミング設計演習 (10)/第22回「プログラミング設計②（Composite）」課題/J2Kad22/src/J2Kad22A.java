import java.util.Scanner;

// AllMenu クラス
class AllMenu extends MenuList {
    public AllMenu() {
        super("★★★ すべてのメニュー ★★★");

        // モーニングメニューを追加
        MorningMenu morningMenu = new MorningMenu();
        add(morningMenu);

        // ランチメニューを追加
        LunchMenu lunchMenu = new LunchMenu();
        add(lunchMenu);

        // ディナーメニューを追加
        DinnerMenu dinnerMenu = new DinnerMenu();
        add(dinnerMenu);
    }
}

public class J2Kad22A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("ファミレスECCへようこそ！");
        while (true) {
            System.out.print("何のメニューを表示しますか？（0：モーニング、1：ランチ、2：ディナー、3：すべて、-1：終了）＞");
            int n = Integer.parseInt(in.next());
            if (n < 0) break;

            // メニューの表示
            Component menu;
            if (n == 0) {
                // モーニングメニュー
                menu = new MorningMenu();
            } else if (n == 1) {
                // ランチメニュー
                menu = new LunchMenu();
            } else if (n == 2) {
                // ディナーメニュー
                menu = new DinnerMenu();
            } else if (n == 3) {
                // すべてのメニュー
                menu = new AllMenu();
            } else {
                // 無効な選択
                continue;
            }

            menu.display();
            System.out.println();
        }
    }
}
