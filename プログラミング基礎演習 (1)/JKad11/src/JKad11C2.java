import java.util.Scanner;

public class JKad11C2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("������!�������֍s����!!");
        System.out.print("���Ȃ��̔N�����͂��Ă�������>");
        int a = sc.nextInt();
        if ( a >=15 ) {
            System.out.println("��l����:500�~�ɂȂ�܂�!");
        }else if ( a >=6 ) {
            if ( a < 15 ) {
                System.out.println("�q������:200�~�ɂȂ�܂�!");
            }
        }else{
            System.out.println("�����ł�!");
        }

    }
}

