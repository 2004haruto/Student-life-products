

import java.util.Scanner;

public class JKad14A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("���p�񓙕ӎO�p�`�̖ʐς����߂܂��I");
        System.out.print("�Εӂ̒�������͂��Ă���������");
        int a = in.nextInt();
        System.out.print("�N�Ɍv�Z�����܂����H�i1�F�o�ؐ��A2�F�������j��");
        int b = in.nextInt();
        if ( b ==1 ) {
            dekisugi(a);
        }else if (b==2) {
            sizuka(a);
        }
    }
    public static void dekisugi(int a){
        double x = a/1.41421356;
        System.out.println("�O�p�`�̖ʐς͒�Ӂ~������2 ������A��ӂƍ��������߂�΂����񂾁I");
        System.out.println("��ӂ�"+x+"�A����������������");
        System.out.println("���p�񓙕ӎO�p�`�̖ʐς�"+ x*x/2+"����!");
    }
    public static void sizuka(int a){
        double y = a*a;
        System.out.println("���p�񓙕ӎO�p�`��4 �Ő����`�ɂȂ邩��A�����`�̖ʐς����߂�4 �Ŋ���΂����񂾂�I");
        System.out.println("�����`�̖ʐς�"+a*a+"������");
        System.out.println("���p�񓙕ӎO�p�`�̖ʐς�"+y/4+"��!");
    }
}
