/*
	課題名：J2Kad21D「ECCソフト株式会社①（委譲）」
	作成日：2023/12/12
	作成者：田中太郎
*/
import java.util.Scanner;

public class J2Kad21D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ECCSoft eccSoft = new ECCSoft();

        while(true) {
            System.out.print("どうしますか？（0：ECCソフトに仕事を発注する、-1：もういい）＞");
            int cmd = Integer.parseInt(in.next());
            if (cmd < 0) break;

            // ECCソフトへ仕事を発注する
            eccSoft.work();

            System.out.println();
        }
    }
}
