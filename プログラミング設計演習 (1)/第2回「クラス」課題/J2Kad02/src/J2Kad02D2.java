/*
    課題名：J2Kad02D2「ヤドンクラス！」
    作成日：2023/09/28
    作成者：正木陽斗
 */

public class J2Kad02D2 {
    public static void main(String[] args) {
        Yadon.showData();

        System.out.println(Yadon.name + "を散歩させます！");
        Yadon.walk();
        Yadon.walk();
        Yadon.walk();
        Yadon.showData();

        System.out.println(Yadon.name + "を眠らせます！");
        Yadon.sleep();
        Yadon.sleep();
        Yadon.sleep();
        Yadon.showData();
    }
}