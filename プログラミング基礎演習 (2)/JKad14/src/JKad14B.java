import java.util.Scanner;

public class JKad14B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("�~�̖ʐς����߂܂��I");
        System.out.print("���a�̒�������͂��Ă���������");
        int a = in.nextInt();
        System.out.print("�N�Ɍv�Z�����܂����H�i1�F�̂ё��A2�F�o�ؐ��j��");
        int b = in.nextInt();
        if ( b ==1 ) {
            nobita(a);
        }else if (b ==2) {
            dekisugi(a);
        }
    }
    public static void nobita(int a) {
        System.out.println("���a"+a+"�̉~�̖ʐς�"+a*a*3+"����!");
    }
    public static void dekisugi(int a) {
        System.out.println("���a"+a+"�̉~�̖ʐς�"+a*a*3.14+"��!");
    }
}
