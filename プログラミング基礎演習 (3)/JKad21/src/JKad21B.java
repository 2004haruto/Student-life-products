import java.util.Scanner;

public class JKad21B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[][] a = {{"ピタゴラス", " アルキメデス ", "ユークリッド", " エラトステネス", " フィボナッチ"},
                        {"デカルト", "フェルマー", " パスカル", " オイラー", " ラプラス"}};
        for (; ; ) {
            System.out.print("階数を入力してください（0～"+(a.length-1)+"）＞");
            int c = in.nextInt();
            if ( c  <0 ){
                break;
            }
            System.out.print("部屋番号を入力してください（0～"+(a[c].length-1)+"）＞");
            int d = in.nextInt();
            System.out.println(c + "階の" + d + "号室には" +a[c][d] + "がいます!");
        }
    }
}




