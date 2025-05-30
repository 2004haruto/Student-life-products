import java.util.Scanner;

public class J2Kad22B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("ファミレスECCへようこそ！");
        while (true) {
            System.out.print("何のメニューを表示しますか？（0：モーニング、1：ランチ、2：ディナー、-1：終了）＞");
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
            } else {
                // 無効な選択
                continue;
            }

            menu.display();
            System.out.println();
        }
    }
}