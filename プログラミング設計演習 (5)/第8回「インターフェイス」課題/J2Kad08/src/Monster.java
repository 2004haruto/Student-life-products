public class Monster {
    protected String name;
    public Monster(String name) {
        this.name = name;
        System.out.println(name + "������Ă����I");
    }
    public void intro() {
        System.out.println("������̖��O��" + name + "�B��낵���ˁI");
    }
    public void walk() {
        System.out.println("�Ă��Ă��E�E�E");
    }
    public void sleep() {
        System.out.println("���������E�E�E");
    }
}
