import java.util.Scanner;

public class JKad10B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("������!�����قɍs����!!");
        System.out.print("���Ȃ��̔N�����͂��Ă�������>");
        int a = sc.nextInt();
        if (a >= 3) {
            if (a >= 65) {
                System.out.println("�V�j�A����:2200�~�ɂȂ�܂�!");
            }
            if (a >= 15 && a < 65) {
                System.out.println("��l����:2400�~�ɂȂ�܂�!");
            }
            if (a >= 6 && a < 15) {
                System.out.println("�q������:1200�~�ɂȂ�܂�!");
            }
            if (a >= 3 && a < 6) {
                System.out.println("�c������:600�~�ɂȂ�܂�!");
            }
        } else {
            System.out.println("�����ł�!");
        }
    }
}




