import java.util.Scanner;

public class JKad09B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("�ЂƂ߂̐�������͂��Ă���������");
        int a = sc.nextInt();
        System.out.print("�ӂ��߂̐�������͂��Ă���������");
        int b = sc.nextInt();
        System.out.print("�N���v�Z���܂����H(1:�̂ё��A1�ȊO:�o�ؐ�>");
        int c = sc.nextInt();
        double d = (double)a/(double)b;
        if ( c==1 ) {
            System.out.println("�̂ё����v�Z���܂��I");
            System.out.println("�u" + (a) + "��" + (b) + "��" + (a / b) + "�ł��I�v");

        } else {
            System.out.println("�o�ؐ����v�Z���܂��I");
            System.out.println("�u" + (a) + "��" + (b) + "��" +d+ "�ł��I�v");
        }
    }
}
