public class Pika {
    public static String name = "�s�J�`���E";    // ���O
    public static int hp = 20;                  // �̗�
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
