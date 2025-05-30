public class JKad22C {
    public static void main(String[] args) {
        System.out.println("メゾンECC の住人たちです！");
        String[][] a = {{"ピタゴラス", " アルキメデス ", "ユークリッド", " エラトステネス", " フィボナッチ"},
                {"デカルト", "フェルマー", " パスカル", " オイラー", " ラプラス"},
                {"フーリエ", "ガウス"}};
        for (int i = 0; i < a.length; i++) {
            System.out.print(i+"階の住人：");
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(j+":"+a[i][j]);
            }
            System.out.println();
        }

    }

}





