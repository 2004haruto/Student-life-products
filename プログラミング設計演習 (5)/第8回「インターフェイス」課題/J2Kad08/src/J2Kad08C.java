/*
	�ۑ薼�FJ2Kad08C�u���d�p���ɒ���I�v
	�쐬���F2023/10/19
	�쐬�ҁF�c�����Y
*/
public class J2Kad08C {
    public static void main(String[] args) {
        // �@FairyMonster�Ƃ���
        FairyMonster fm = new FairyMonster("�s�N�V�[");
        fm.intro();
        fm.walk();
        fm.sleep();
        fm.heal();

        System.out.println();

        // �AMonster�Ƃ���
        Monster m = fm;
        m.intro();
        m.walk();
        m.sleep();
        //m.heal();


        System.out.println();

        // �BFairy�܂���IFairy�Ƃ���
        Fairy f =fm;
        f.intro();
        //f.walk();
        //f.sleep();
        f.heal();


    }
}
