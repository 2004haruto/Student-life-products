import java.util.Scanner;

public class JKad11A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("������!�������֍s����!!");
        System.out.print("���l�ōs���܂���?>");
        int a = sc.nextInt();
        System.out.print("���Ȃ��̔N�����͂��Ă�������>");
        int b = sc.nextInt();
        if (a >= 1) {
            if (a < 30) {
                if (b >= 15) {
                    System.out.println("��l����:500�~�ɂȂ�܂�!");
                } else if (b >= 6) {
                        System.out.println("�q������:200�~�ɂȂ�܂�!");
                } else {
                    System.out.println("�����ł�!");
                }
            }
             else if (a < 50) {
                    if (b >= 15) {
                        System.out.println("��l����:450�~�ɂȂ�܂�!");
                    } else if (b >= 6) {
                            System.out.println("�q������:180�~�ɂȂ�܂�!");
                    } else {
                        System.out.println("�����ł�!");
                    }
                }
                else if (b >= 15) {
                        System.out.println("��l����:400�~�ɂȂ�܂�!");
                    } else if (b >= 6) {
                            System.out.println("�q������:160�~�ɂȂ�܂�!");
                    } else {
                        System.out.println("�����ł�!");
                    }
                }
            }
        }


