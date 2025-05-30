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
    private String name;
    public Monster() {
        name = nameData[(int)(Math.random() * nameData.length)];
        System.out.println(name + "がやってきた！");
    }
    @Override
    public String toString() { return name; }
}
