/*
	課題名：J2Kad06B「月面着陸ゲーム！③（ロケット選択）」
	作成日：2023/10/12
	作成者：田中太郎
*/
import java.util.Scanner;

public class J2Kad06B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("月面着陸ゲーム！");
        System.out.println("ロケットを操って無事着陸してください。");
		System.out.println("高度が0以下になったら着陸です。");
		System.out.println("ただし、落下速度が10を越えているとロケットは粉々になります。");
		System.out.println("うまく逆噴射して、着陸してください。");
		System.out.println();

        System.out.print("使用するロケットを選択してください（1：旧型、それ以外：新型）＞");
        int rocketChoice = in.nextInt();
        Rocket r ;
        if(rocketChoice == 1){
            r = new Rocket(15,300);
        }else {
            r = new Rocket2(15,300);
        }

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
