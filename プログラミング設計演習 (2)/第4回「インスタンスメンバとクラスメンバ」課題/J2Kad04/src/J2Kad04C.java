/*
    課題名：J2Kad04C「クラスメソッド」
    作成日：2023/10/05
    作成者：正木陽斗
 */
public class J2Kad04C {
    public static void main(String[] args) {
        Sheep.countSheep();
        Sheep s1 = new Sheep();
        Sheep s2 = new Sheep();
        Sheep s3 = new Sheep();
        Sheep.countSheep();
        s1.intro();
        s2.intro();
        s3.intro();
    }
}
