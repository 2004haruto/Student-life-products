/*
	課題名：J2Kad06C「ポリモーフィズム」
	作成日：2023/10/12
	作成者：田中太郎
*/
public class J2Kad06C {
    public static void main(String[] args) {
        // Monster
        Monster m = new Monster("ピカチュウ");
        m.intro();
        System.out.println();

        // FireMonster
        m = new FireMonster("ヒトカゲ");
        m.intro();
        System.out.println();

        // RockMonster
        m = new RockMonster("カブト");
        m.intro();
    }
}
