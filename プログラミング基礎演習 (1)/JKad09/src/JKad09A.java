import java.util.Scanner;

public class JKad09A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("�̂ё��̓_������͂��Ă�������>");
        int a = sc.nextInt();
        System.out.print("�����������̓_������͂��Ă�������>");
        int b = sc.nextInt();
        System.out.print("�W���C�A���̓_������͂��Ă�������>");
        int c = sc.nextInt();
        System.out.print("�X�l�v�̓_������͂��Ă�������>");
        int d = sc.nextInt();
        System.out.print("�o�ؐ�����̓_������͂��Ă�������>");
        int e = sc.nextInt();

        int max = a;
        if (max<a) {
            max = a;
        }
        if (max<b) {
            max = b;
        }
        if (max<c) {
            max = c;
        }
        if (max<d) {
            max = d;
        }
        if (max<e) {
            max = e;
        }
        System.out.println("��ԍ����_����"+ max + "�ł��I");
        }

    }

