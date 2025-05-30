/*
    課題名：J2Kad01D2「フィールド」
    作成日：2023/09/26
    作成者：田中太郎
 */
public class J2Kad01D2 {
    //ここで変数x を宣言する
    public static int x = 10;
    public static void add5() {
        //x に5 を加算する
        x = x + 5;
        System.out.println("x に5 を足しました！");
    }
    public static void main(String[] args) {
        //int x = 10;
        //add5 を3 回呼び出す
        add5();
        add5();
        add5();
        System.out.println("x：" + x);
    }
}
