/*
	�ۑ薼�FJ2Kad05D�u�N���X�̌p���v
	�쐬���F2023/10/10
	�쐬�ҁF���ؗz�l
*/
public class J2Kad05D {
    public static void main(String[] args) {
        // �s�J�`���E
        Monster pika = new Monster();
        pika.setName("�s�J�`���E");
        pika.intro();
        pika.walk();
        pika.sleep();

        System.out.println();
        // ���b�N��
        FlyMonster muku = new FlyMonster();
        muku.setName("���b�N��");
        muku.intro();
        muku.walk();
        muku.sleep();
        muku.fly();
    }
}
