public class Yadon {
    public static String name = "���h��";    // ���O
    public static int hp = 30;                  // �̗�
    public static void showData() {
        System.out.println("�ڂ��̖��O��" + name + "�IHP��" + hp + "����I");
    }
    public static void walk() {
        System.out.println("�Ă��Ă��E�E�E");
        hp--;
    }
    public static void sleep() {
        System.out.println("���������E�E�E");
        hp++;
    }
}
