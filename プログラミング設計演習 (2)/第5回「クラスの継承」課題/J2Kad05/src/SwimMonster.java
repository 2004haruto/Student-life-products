public class SwimMonster extends Monster{
    public SwimMonster(){
        System.out.println("SwimMonster �N���X�̃R���X�g���N�^���Ăяo����܂����I");
    }
    public void swim(){
        System.out.println(super.name+"���j����I�Ԃ��Ԃ����");
    }
    public void walk(){
        System.out.println("���тꂾ�ƕ����Ȃ���`");
    }
    public void intro() {
        super.intro();
            System.out.println("�j�������ӂ��I");

    }
}
