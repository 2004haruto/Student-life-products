/*
    課題名：J2Kad01D1「ローカル変数」
    作成日：2023/09/26
    作成者: 正木陽斗
 */
public class J2Kad01D1 {
    public static void add5(int x) {
        //x に5 を加算する
        x = x + 5;
        System.out.println("x に5 を足しました！");
    }
    public static void main(String[] args) {
        int x = 10;
        //add5 を3 回呼び出す
        add5(x);
        add5(x);
        add5(x);
        System.out.println("x：" + x);
    }
}
