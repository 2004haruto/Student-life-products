/*
	�ۑ薼�FJ2Kad06D�u�X�[�p�[�N���X�̎Q�Ɓv
	�쐬���F2023/10/12
	�쐬�ҁF�c�����Y
*/
public class J2Kad06D {
    public static void main(String[] args) {
        // Monster
        Monster m0 = new Monster("�s�J�`���E");
        m0.intro();
        System.out.println();

        // FireMonster
        Monster hito = new FireMonster("�q�g�J�Q");
        hito.intro();
        //hito.fire();
        System.out.println();

        // RockMonster
        Monster kabuto = new RockMonster("�J�u�g");
        kabuto.intro();
        //kabuto.defend();
    }
}
