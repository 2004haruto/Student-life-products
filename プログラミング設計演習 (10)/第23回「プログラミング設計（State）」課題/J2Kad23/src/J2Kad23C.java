/*
    課題名：J2Kad23C「状態クラス」
    作成日：2024/1/9
    作成者：田中太郎
*/
import java.util.Scanner;

public class J2Kad23C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("ガチャガチャをします！");

        GachaMachine gm = new GachaMachine();
        GachaState gs = null;
        while(true) {
            System.out.print("どの状態をチェックしますか？（0：NoCoin、1：HasCoin、-1：終わる）＞");
            int n = Integer.parseInt(in.next());
            if (n < 0) break;

            // 選択した状態クラスを生成し各メソッドを実行する
            switch(n) {
                case 0: gs = new NoCoin();   break;
                case 1: gs = new HasCoin();   break;
            }
            if (gs != null){
                gs.showState();
                gs.insertCoin(gm);
                gs.turnHandle(gm);
                gs.ejectCoin(gm);
            }
            System.out.println();
        }
    }
}