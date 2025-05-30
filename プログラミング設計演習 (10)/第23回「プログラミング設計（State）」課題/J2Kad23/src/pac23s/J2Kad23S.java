/*
	課題名：pac23S.J2Kad23S「ストップウォッチ！（Stateパターン版）」
	作成日：2024/1/9
	作成者：田中太郎
*/
package pac23s;

import java.util.Scanner;

public class J2Kad23S {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StopWatch sw = new StopWatch();
        while(true) {
            sw.showState();
            System.out.print("どうしますか？（0：START、1：CLEAR、-1：終了）＞");
            int cmd = Integer.parseInt(in.next());
            if (cmd < 0) break;

            switch(cmd) {
                case 0:     sw.start();      break;
                case 1:     sw.clear();      break;
                default:    sw.noAction();   break;
            }
        }
    }
}
