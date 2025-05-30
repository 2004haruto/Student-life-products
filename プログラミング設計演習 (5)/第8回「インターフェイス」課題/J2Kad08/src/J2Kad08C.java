/*
	課題名：J2Kad08C「多重継承に挑戦！」
	作成日：2023/10/19
	作成者：田中太郎
*/
public class J2Kad08C {
    public static void main(String[] args) {
        // ①FairyMonsterとして
        FairyMonster fm = new FairyMonster("ピクシー");
        fm.intro();
        fm.walk();
        fm.sleep();
        fm.heal();

        System.out.println();

        // ②Monsterとして
        Monster m = fm;
        m.intro();
        m.walk();
        m.sleep();
        //m.heal();


        System.out.println();

        // ③FairyまたはIFairyとして
        Fairy f =fm;
        f.intro();
        //f.walk();
        //f.sleep();
        f.heal();


    }
}
