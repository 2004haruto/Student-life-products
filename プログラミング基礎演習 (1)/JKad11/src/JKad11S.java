import java.util.Scanner;

public class JKad11S {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("�O�p�`�����܂�!");
        System.out.print("��1�̒�������͂��Ă�������>");
        int a = sc.nextInt();
        System.out.print("��2�̒�������͂��Ă�������>");
        int b = sc.nextInt();
        System.out.print("��3�̒�������͂��Ă�������>");
        int c = sc.nextInt();

        if ( a >= (b + c) || b >= (a + c) || c >= (a + b)) {
            System.out.println("�O�p�`�ɂȂ�܂���!");
        }else if ( a == b && b == c ) {
            System.out.println("���O�p�`�ɂȂ�܂�!");
        }else if ( a == b || b == c || a == c ) {
            System.out.println("�񓙕ӎO�p�`�ɂȂ�܂�!");
        }else {
            System.out.println("�O�p�`�ɂȂ�܂�!");
        }

    }
}
