/*
	課題名：J2Kad06S1「石取りゲームの簡略化」
	作成日：2023/10/12
	作成者：田中太郎
*/
import java.util.Scanner;

public class J2Kad06S1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 説明の表示
        System.out.println("20個ある石を交互に取っていきます。一度に取れる石の数は1-3個です。");
        System.out.println("最後の1つを取った方が負けです。");
        System.out.println();

        // プレイヤー選択
        UserPlayer user = new UserPlayer();
        BasePlayer base = new BasePlayer();
        System.out.println();

        // 自己紹介
        user.intro();
        base.intro();
        System.out.println();

        int	stone = 20;			// 石の数
        int take;				// 取る石の数
        while(true) {
            // 先手の手番
            showStone(stone);
            System.out.println(user + "の番です。");
            take = user.takeStone(stone);
            System.out.println(take + "個取りました！");
            stone -= take;
            if (stone <= 0) {
                System.out.println(user + "の負けです！");
                break;								// while文を抜ける
            }
            System.out.println();

            // 後手の手番
            showStone(stone);
            System.out.println(base + "の番です。");
            take = base.takeStone(stone);
            System.out.println(take + "個取りました！");
            stone -= take;
            if (stone <= 0) {
                System.out.println(base + "の負けです！");
                break;								// while文を抜ける
            }
            System.out.println();
        }
    }
    public static void showStone(int stone) {
        System.out.print("残り" + stone + "個：");
        while(stone > 0) {
            System.out.print("●");
            stone--;
        }
        System.out.println();
    }
}
