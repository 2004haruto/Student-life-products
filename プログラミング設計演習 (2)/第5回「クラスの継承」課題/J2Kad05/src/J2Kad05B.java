/*
	課題名：J2Kad05B「月面着陸ゲーム！（新型ロケット）」
	作成日：2023/10/10
	作成者：正木陽斗
*/
import java.util.Scanner;

public class J2Kad05B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("月面着陸ゲーム！");
        System.out.println("ロケットを操って無事着陸してください。");
		System.out.println("高度が0以下になったら着陸です。");
		System.out.println("ただし、落下速度が10を越えているとロケットは粉々になります。");
		System.out.println("うまく逆噴射して、着陸してください。");
		System.out.println();
		System.out.println("幸運を祈る！！");
		System.out.println();

        Rocket r = new Rocket(15, 300);

        while(true) {
            r.showData();
            if (r.getHeight() <= 0) break;
            // コマンド入力
            System.out.print("逆噴射しますか？（1：する、それ以外：しない）＞");
            int cmd = in.nextInt();
            if (cmd == 1) r.useFuel();
            r.move();
            System.out.println();
        }

        // 結果判定
        if ( r.getSpeed() > 10 ) {
            System.out.println("ズキューン！着陸失敗！！");
        } else {
            System.out.println("おめでとう！着陸成功！！");
        }
        in.close();
    }
}
