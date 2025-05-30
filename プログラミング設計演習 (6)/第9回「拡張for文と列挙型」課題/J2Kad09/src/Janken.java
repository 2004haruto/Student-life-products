public class Janken {
//        enum Result {
//            WIN,
//            LOSE,
//            DRAW,
//        }
enum Result {
    WIN("あなたの勝ちです！"),
    LOSE("あなたの負けです！"),
    DRAW("引き分けです！");
    public String msg; // 勝敗メッセージ
    Result(String msg) { this.msg = msg; } // コンストラクタ
}

    enum Hand {
        GU("グー", "チョキに勝って、パーに負けます！"), // 名前、特徴
        CHOKI("チョキ", "パー勝って、グーに負けます！"), // 名前、特徴
        PA("パー", "グーに勝って、チョキに負けます！"); // 名前、特徴
        public String name; // 名前
        public String feature; // 特徴
        Hand(String name,String feature){
            this.name = name;
            this.feature = feature;
    }
    String getName(){
            return name;
    }
}


    public static Result[][] resultTbl = {
                {Result.DRAW,Result.WIN,Result.LOSE},
                {Result.LOSE,Result.DRAW,Result.WIN},
                {Result.WIN,Result.LOSE,Result.DRAW},
        };
}
