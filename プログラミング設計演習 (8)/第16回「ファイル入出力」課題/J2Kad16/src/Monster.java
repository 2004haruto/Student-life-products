public class Monster {
    private static String nameData[] = {
            "ウインディ",
            "イシツブテ",
            "イワンコ",
            "オコリザル",

            "カビゴン",
            "ケンタロン",
            "キャタピー",
            "ギャラドス",
            "キングラー",
            "ゴースト",

            "サンド",
            "ジュゴン",
            "スピアー",
            "スリープ",
            "ゼニガメ",

            "ディグダ",
            "ドードー",
            "トランセル",
            "ドククラゲ",

            "ナゾノクサ",
            "ニャビー",
            "ニドラン",

            "バタフリー",
            "ピカチュウ",
            "ピジョン",
            "ヒトカゲ",
            "フシギダネ",
            "ベトベトン",

            "マルマイン",
            "ミニリュウ",
            "ミュウ",
            "ムックル",
            "モクロー",

            "ヤドン",
            "ユンゲラー",

            "ラッタ",
            "ラプラス",
            "リザードン",
            "レアコイル",
    };
    private static int rest = nameData.length;
    private String name;

    public Monster() {
        int n = (int)(Math.random() * rest);
        name = nameData[n];
        rest--;
        nameData[n] = nameData[rest];
        nameData[rest] = name;
        if (rest == 0) rest = nameData.length;
    }
    @Override
    public String toString() { return name; }
    public String getName() { return name; }
}
