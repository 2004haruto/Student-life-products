import java.util.Scanner;

public class JKad09C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("�ЂƂ��������S��H�ׂ܂��I");
        System.out.print("�����S�̐�����͂��Ă�������>");
        int a = sc.nextInt();
        System.out.print("�H�ׂ�l�̐�����͂��Ă�������>");
        int b = sc.nextInt();
        if ( a<b ) {
            System.out.println("�����S�̐�������܂���I");

        } else {
            System.out.println("�ЂƂ��������S��H�ׂ��I");
            System.out.println("�c���������S��" +( a-b )+ "�ł��I");
        }
    }
}
