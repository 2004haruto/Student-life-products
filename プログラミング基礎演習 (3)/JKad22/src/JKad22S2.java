public class JKad22S2 {
    public static void main(String[] args) {
        String[][][] a = {{{"ピタゴラス", " アルキメデス ", "ユークリッド", " エラトステネス", " フィボナッチ"},
                {"デカルト", "フェルマー", " パスカル", " オイラー", " ラプラス"},
                {"フーリエ", "ガウス"}},
                {{"ド・モルガン", " ブール", " リーマン", " ポアンカレ"}, {"ラッセル", " ニュートン", " テイラー"}}};
        System.out.println("メゾンECC の住人たちです！");
        for (int i = 0; i < a.length; i++) {
            System.out.println(i + "号館");
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(j + "階の住人：");
                for (int k = 0; k < a[i][j].length; k++) {
                    System.out.print(k + ":" + a[i][j][k]);
                }
                System.out.println();
            }
        }
    }
}
