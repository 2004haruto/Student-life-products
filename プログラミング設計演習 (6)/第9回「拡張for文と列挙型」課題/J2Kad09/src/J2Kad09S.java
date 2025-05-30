/*
	課題名：J2Kad09S「じゃんけん（クラス版）」
	作成日：2023/10/24
	作成者：田中太郎
*/
public class J2Kad09S {
    public static void main(String[] args) {
        System.out.println("じゃんけんをします！");
        BasePlayer p0 = new UserPlayer();
        BasePlayer p1 = new CompPlayer();

        while(true) {
            // 手の選択
            Hand h0 = p0.createHand();
            if (h0 == null) break;
            Hand h1 = p1.createHand();
            if (h1 == null) break;
            // 手の表示
            System.out.println(p0 + "は" + h0 + "を出した！");
            System.out.println(p1 + "は" + h1 + "を出した！");

            // 結果表示（作成すること）


            System.out.println();
        }
    }
}
