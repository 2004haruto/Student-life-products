import java.util.Scanner;

public class JKad10A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("������!�������ɍs����!");
        System.out.print("���l�ōs���܂���?>");
        int a = sc.nextInt();
        System.out.print("���Ȃ��̔N�����͂��Ă�������>");
        int b = sc.nextInt();
        if (b>=15) {
            if (a < 30) {
                System.out.println("��l����:500�~�ɂȂ�܂�!");
            }
            if (a >= 30 && a < 50) {
                System.out.println("��l����:450�~�ɂȂ�܂�!");
            }
            if (a >= 50) {
                System.out.println("��l����:400�~�ɂȂ�܂�!");
            }
        }
        if (b >=6 && b<15) {
            if (a < 30) {
                System.out.println("�q������:200�~�ɂȂ�܂�!");
            }
            if (a >= 30 && a < 50) {
                System.out.println("�q������:180�~�ɂȂ�܂�!");
            }
            if (a >= 50) {
                System.out.println("�q������:160�~�ɂȂ�܂�!");
            }
        }
        if (b <6) {
            System.out.println("�����ł�!");
            }
        }
    }



