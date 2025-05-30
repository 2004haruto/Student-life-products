public class Sheep {
    private static String[] nameData = {
            "ピタゴラス",
            "アルキメデス",
            "エラストテネス",
            "ユークリッド",
            "フィボナッチ",
            "デカルト",
            "フェルマー",
            "パスカル",
            "オイラー",
            "ラプラス",
            "フーリエ",
            "ガウス",
            "ド・モルガン",
            "ブール",
            "リーマン",
            "ポアンカレ",
            "ラッセル",
            "ニュートン",
            "テイラー",

            "ケプラー",
            "ガリレオ",
            "ボイル",
            "フック",
            "ホイヘンス",
            "ベルヌイ",
            "ラグランジュ",
            "ファラデー",
            "ジュール",
            "フーコー",
            "ストークス",
            "マクスウェル",
            "マッハ",
            "レントゲン",
            "キュリー",
            "ラザフォード",
            "アインシュタイン",
    };
    private static int rest = nameData.length;
    protected String name;

    public Sheep() {
        int n = (int)(Math.random() * rest);
        name = nameData[n];
        rest--;
        nameData[n] = nameData[rest];
        nameData[rest] = name;
        if (rest == 0) rest = nameData.length;

//        System.out.println(name + "がやってきた！");
    }
    public void intro() {
        System.out.println("「わたしは" + name + "、よろしくメェ～！」");
    }
    public String toString() { return name; }
}
