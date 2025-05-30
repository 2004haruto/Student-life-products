package pac22d;

import java.util.Scanner;

public class J2Kad22D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("ファミレスECCへようこそ！");
        while (true) {
            System.out.print("どうしますか？（0：単品表示、1：一覧表示、-1：終了）＞");
            int n = Integer.parseInt(in.next());
            if (n < 0) break;

            // メニューの表示
            if (n == 0) {
                // 単品表示
                MenuItem morningSet = new MenuItem("モーニングセット", 400);
                morningSet.printItem();
            } else if (n == 1) {
                // 一覧表示
                MorningMenu morningMenu = new MorningMenu();
                morningMenu.printList();
            }

            System.out.println();
        }
    }
}
