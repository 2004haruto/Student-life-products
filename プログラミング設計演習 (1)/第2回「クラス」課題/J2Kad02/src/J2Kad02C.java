/*
    課題名：J2Kad02C「モンスタークラス！」
    作成日：2023/09/28
    作成者：正木陽斗
 */

public class J2Kad02C {
    public static void main(String[] args) {
        Monster dialga = new Monster();
        dialga.setData("ディアルガ",1000);
        dialga.showData();
        Monster king = new Monster();
        king.setData("コイキング",1);
        king.showData();
        System.out.println(dialga.name+"を散歩させます！");
        dialga.walk();
        dialga.walk();
        dialga.walk();
        dialga.showData();
        System.out.println(king.name+"を散歩させます！");
        king.walk();
        king.walk();
        king.walk();
        king.showData();
    }
}
