import java.util.Scanner;

public class JKad11B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("������!�����ق֍s����!!");
        System.out.print("���Ȃ��̔N�����͂��Ă�������>");
        int a = sc.nextInt();
        if ( a >=65 ) {
            System.out.println("�V�j�A����:2200�~�ɂȂ�܂�!");
        }else if ( a >= 15 ) {
                System.out.println("��l����:2400�~�ɂȂ�܂�!");
        }else if ( a >= 6 ) {
                System.out.println("�q������:1200�~�ɂȂ�܂�!");
        }else if ( a >= 3 ) {
                System.out.println("�c������:600�~�ɂȂ�܂�!");
        }else{
            System.out.println("�����ł�!");
        }
    }
}
