/*
	課題名：J2Kad05C「オーバーライド」
	作成日：2023/10/10
	作成者：正木陽斗
*/
public class J2Kad05C {
    public static void main(String[] args) {
        // コイキング
        SwimMonster king = new SwimMonster();
        king.setName("コイキング");
        king.intro();
        king.walk();
        king.sleep();
        king.swim();
    }
}
