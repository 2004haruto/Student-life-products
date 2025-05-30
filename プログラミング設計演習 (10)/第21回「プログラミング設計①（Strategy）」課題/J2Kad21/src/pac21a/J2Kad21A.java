package pac21a;

import java.util.Scanner;

public class J2Kad21A {
    public static void main(String[] args) {
        FamiredoComputer famiredoComputer = new FamiredoComputer();
        Scanner scanner = new Scanner(System.in);

        System.out.println("ファミコンを買ってもらった！");
        System.out.println("ゲームソフトも買ってもらった！");

        while (true) {
            System.out.println("どうしますか？（0：遊ぶ、1：カセットをセットする、-1：1 時間遊んだのでやめる）＞");
            int choice = scanner.nextInt();

            if (choice == -1) {
                break;
            } else if (choice == 0) {
                famiredoComputer.play();
            } else if (choice == 1) {
                System.out.println("どれをセットしますか？（0：マリオ、1：ゼルダ、2：スマブラ、3：カセットを取り外す）＞");
                int gameChoice = scanner.nextInt();

                FCCassette cassette = null;
                switch (gameChoice) {
                    case 0:
                        cassette = new FCMario();
                        break;
                    case 1:
                        cassette = new FCZelda();
                        break;
                    case 2:
                        cassette = new FCSmash();
                        break;
                    case 3:
                        famiredoComputer.removeCassette();
                        break;
                    default:
                        System.out.println("無効な選択です。");
                        break;
                }

                if (cassette != null) {
                    famiredoComputer.setCassette(cassette);
                }
            }
        }
    }
}