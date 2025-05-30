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
    private String name;
    public Sheep() {
        name = nameData[(int)(Math.random() * nameData.length)];
        System.out.println(name + "がやってきた！");
    }
    public String toString() { return name; }
}
