import java.util.Scanner;

public class JKad15S {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("�g�[�i�����g�̃`�[��������͂��Ă���������");
        int a = in.nextInt();
        System.out.print("�N�����������v�Z���܂����H�i1�F�o�ؐ��A����ȊO�F�������j��");
        int n = in.nextInt();
        if (n == 1) {
            dekisugi(a);
            System.out.println("�g�[�^���̎�������"+(a-1)+"����");
        } else {
            sizuka(a);
        }
    }

    public static void dekisugi(int a) {
        System.out.println("����Ȃ̊ȒP���I");
        int b = 1;
        while (a > 1) {
            int c = a / 2;
            int d = a % 2;
            int e = c + d;
            System.out.println(b + "���̎������F" + c + " �s�폟�F" + d + " �c��`�[���F" + e);
            a = e;
            b++;
        }

    }

    public static void sizuka(int a) {
        System.out.println("����Ȃ̊ȒP��I");
        System.out.println("1�����Γ����ɂȂ�");
        int ab = a - 1;
        System.out.println("�Ō��1�`�[���c�邽�߂ɂ�" + ab + "��������΂����̂�!");
    }
}
