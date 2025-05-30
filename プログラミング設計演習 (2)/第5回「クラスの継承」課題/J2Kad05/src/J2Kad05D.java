/*
	課題名：J2Kad05D「クラスの継承」
	作成日：2023/10/10
	作成者：正木陽斗
*/
public class J2Kad05D {
    public static void main(String[] args) {
        // ピカチュウ
        Monster pika = new Monster();
        pika.setName("ピカチュウ");
        pika.intro();
        pika.walk();
        pika.sleep();

        System.out.println();
        // ムックル
        FlyMonster muku = new FlyMonster();
        muku.setName("ムックル");
        muku.intro();
        muku.walk();
        muku.sleep();
        muku.fly();
    }
}
