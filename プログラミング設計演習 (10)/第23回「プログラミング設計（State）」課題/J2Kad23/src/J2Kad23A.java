/*
    課題名：J2Kad23A「ガチャガチャマシーン完成！」
    作成日：2024/1/9
    作成者：田中太郎
*/
import java.util.Scanner;

public class J2Kad23A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("ガチャガチャをします！");

        GachaMachine gm = new GachaMachine();
        while(true) {
            gm.showState();
            System.out.print("どうしますか？（0：コインを入れる、1：ハンドルを回す、2：返却ボタンを押す、-1：終わる）＞");
            int cmd = Integer.parseInt(in.next());
            if (cmd < 0) break;

            switch(cmd) {
                case 0: gm.insertCoin();   break;
                case 1: gm.turnHandle();   break;
                case 2: gm.ejectCoin();    break;
            }
        }
    }
}