/*
	課題名：J2Kad22C「Compositeパターンへの道②（インターフェイスの共通化）」
	作成日：2023/12/14
	作成者：田中太郎
*/
import java.util.Scanner;

public class J2Kad22C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("ファミレスECCへようこそ！");
        while (true) {
            System.out.print("どうしますか？（0：単品表示、1：一覧表示、-1：終了）＞");
            int n = Integer.parseInt(in.next());
            if (n < 0) break;

            // メニューの表示



            System.out.println();
        }
    }
}
