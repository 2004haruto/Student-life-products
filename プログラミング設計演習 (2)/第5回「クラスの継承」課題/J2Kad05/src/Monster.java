public class Monster {
    protected String name;
    public Monster() { System.out.println("Monster�N���X�̃R���X�g���N�^���Ăяo����܂����I"); }
    public void setName(String name) {
        this.name = name;
    }
    public void intro() {
        System.out.println("������̖��O��" + name + "�B");
        System.out.println("��͎U���B���Z�͂ǂ��ł�����邱�Ƃ���B");
    }
    public void walk() {
        System.out.println("�Ă��Ă��E�E�E");
    }
    public void sleep() {
        System.out.println("���������E�E�E");
    }
}
