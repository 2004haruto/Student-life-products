/*
    �ۑ薼�FJ2Kad01C�u�s�J�`���E����I�v
    �쐬���F2023/09/26
    �쐬�ҁF���ؗz�l
 */
public class J2Kad01C {
    public static String name = "�s�J�`���E";
    public static int hp = 20;
    public static void showData() {
        System.out.println("�l�̖��O��"+name+"!HP��"+hp+"����!");
    }
    public static void walk() {
        System.out.println("�Ă��Ă��E�E�E");
        hp = hp - 1 ;
    }
    public static void sleep() {
        System.out.println("���������E�E�E");
        hp = hp + 1;
    }

    public static void main(String[] args) {
        showData();
        walk();
        walk();
        walk();
        showData();
        sleep();
        sleep();
        sleep();
        showData();
    }
}
