import java.util.Scanner;

public class J2Kad07A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("ECC�R�[�q�[�ւ悤�����I");
        System.out.println("��O�s�o�̃��V�s�ō�邩��A����������I�I");
        System.out.println();

        while (true) {
            System.out.print("�������́H�i0�F�R�[�q�[�A1�G�g���A2�F�R�R�A�A-1�F�X���o��j��");
            int    n = in.nextInt();
            if (n < 0) break;
            HotDrink a;
            switch (n) {
                default:
                case 0: // �R�[�q�[�����
                    a = new Coffee();
                    break;
                case 1: // �g�������
                    a = new Tea();
                    break;
                case 2:
                    a =new Cocoa();
                    break;

            }
            a.execute();
            System.out.println("���҂������܂����I���������ǂ����I");
            System.out.println();
        }

        System.out.println("���肪�Ƃ��������܂����I");
    }
}