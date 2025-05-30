public class Car {
    private static String[] nameData = {
            "ルーミー",
            "ヤリス",
            "アクア",
            "パッソ",
            "シエンタ",
            "ノア",
            "ヴォクシー",
            "カローラ",
            "カムリ",
            "プリウス",
            "ハリアー",
            "ライズ",
            "RAV4",
            "クラウン",
            "スープラ",

            "N-VAN",
            "N-BOX",
            "N-WGN",
            "アコード",
            "インサイト",
            "シビック",
            "フィット",
            "ステップワゴン",

            "リーフ",
            "ノート",
            "マーチ",
            "ルークス",
            "デイズ",
            "エルグランド",
            "セレナ",
            "エクストレイル",
            "GT-R",
            "フェアレディZ",
            "スカイライン",

            "アウトランダー",
            "エクリプス",
            "デリカ",
            "ミラージュ",

            "アルト",
            "ハスラー",
            "スペーシア",
            "スイフト",
            "ソリオ",

            "ムーブ",
            "タント",
    };
    private static int rest = nameData.length;
    private String name;

    public Car() {
        int n = (int)(Math.random() * rest);
        name = nameData[n];
        rest--;
        nameData[n] = nameData[rest];
        nameData[rest] = name;
        if (rest == 0) rest = nameData.length;
    }
    public String toString() { return name; }
}
