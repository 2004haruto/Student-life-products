/*
	課題名：J2Kad14S「じゅげむじゅげむ・・・」
	作成日：2023/11/14
	作成者：田中太郎
*/
public class J2Kad14S {
    public static void main(String[] args) {
        // インスタンスの生成
        Phrase p0 = new Phrase("じゅげむ じゅげむ ごこうのすりきれ");
        Phrase p1 = new Phrase("かいじゃりすいぎょの すいぎょうまつ うんらいまつ ふうらいまつ");
        Phrase p2 = new Phrase("くうねるところに すむところ やぶらこうじの ぶらこうじ");
        Phrase p3 = new Phrase("パイポパイポ パイポのシューリンガン");
        Phrase p4 = new Phrase("シューリンガンのグーリンダイ");
        Phrase p5 = new Phrase("グーリンダイのポンポコピーのポンポコナーの");
        Phrase p6 = new Phrase("ちょうきゅうめいの ちょうすけ");

        // インスタンスの連結
        p0.setNext(p1).setNext(p2).setNext(p3).setNext(p4).setNext(p5).setNext(p6);

        // 表示
        Phrase p = p0;
        while (p != null) {
            System.out.println(p);              // フレーズの表示
            p = p.getNext();                    // 次のフレーズへ
        }
    }
}
