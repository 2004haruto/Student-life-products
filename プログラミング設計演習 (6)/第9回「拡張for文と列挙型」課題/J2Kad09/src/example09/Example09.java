package example09;

public class Example09 {
    public static void main(String[] args) {
        Monster[] monsters = {new Monster("ピカチュウ"),new Monster("ゼニガメ"),new Monster("ヘイガニ")};

        //今までのfor文
        for (int i = 0; i < monsters.length; i++) {
            monsters[i].intro();
        }

        //拡張for文
        for (Monster m:monsters) {
            m.intro();
        }

        //２次元配列パターン
        String[][] names ={
                {"ヒトカゲ","アチャモ"},
                {"フシギダネ","キモリ"}
        } ;

        for (int i = 0; i < names.length; i++){
            for (int j = 0; j < names[i].length; j++){
                System.out.println(names[i][j]);
            }
        }
        //拡張for文
        for (String[] name :names) {
            for (String n: name) {
                System.out.println(n);
            }
        }
    }
}
