/*
	課題名：J2Kad06D「スーパークラスの参照」
	作成日：2023/10/12
	作成者：田中太郎
*/
public class J2Kad06D {
    public static void main(String[] args) {
        // Monster
        Monster m0 = new Monster("ピカチュウ");
        m0.intro();
        System.out.println();

        // FireMonster
        Monster hito = new FireMonster("ヒトカゲ");
        hito.intro();
        //hito.fire();
        System.out.println();

        // RockMonster
        Monster kabuto = new RockMonster("カブト");
        kabuto.intro();
        //kabuto.defend();
    }
}
