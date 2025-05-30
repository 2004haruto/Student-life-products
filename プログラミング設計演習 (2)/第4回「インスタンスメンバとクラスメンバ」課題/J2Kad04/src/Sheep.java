public class Sheep {
    private static int n = 0;
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
    private String name;

    public static void countSheep(){
        System.out.println("羊は全部で"+n+"匹です！");
    }

    public Sheep() {
        name = nameData[(int)(Math.random() * nameData.length)];
        System.out.println(name + "がやってきた！");
        n++;
    }
    public void intro() {
        System.out.println("「わたしは" + name + "、よろしくメェ～！」");
    }
}
