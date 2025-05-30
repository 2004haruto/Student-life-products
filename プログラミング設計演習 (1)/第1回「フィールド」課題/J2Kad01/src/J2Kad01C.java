/*
    課題名：J2Kad01C「ピカチュウ現る！」
    作成日：2023/09/26
    作成者：正木陽斗
 */
public class J2Kad01C {
    public static String name = "ピカチュウ";
    public static int hp = 20;
    public static void showData() {
        System.out.println("僕の名前は"+name+"!HPは"+hp+"だよ!");
    }
    public static void walk() {
        System.out.println("てくてく・・・");
        hp = hp - 1 ;
    }
    public static void sleep() {
        System.out.println("ぐうぐう・・・");
        hp = hp + 1;
    }

    public static void main(String[] args) {
        showData();
        walk();
        walk();
        walk();
        showData();
        sleep();
        sleep();
        sleep();
        showData();
    }
}
