import  java.util.Scanner;

public class JKad21D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] names = {"�̂ё�", "������", "�W���C�A��", "�X�l�v", "�o�ؐ�",};
        int[] scores = new int[names.length];
        // �_���̓���
        int i = 0;
        for (;i < names.length;i++) {
            System.out.print(names[i] + "�̓_���i-1�F���ȁj��");
            scores[i] = in.nextInt();
        }
        // ���ϓ_�̌v�Z
        int sum = 0; // ���v
        int n = 0; // �󌱂����l��
        i = 0;
        for (;i < names.length;i++) {
            if (scores[i] == -1) {
                continue;
            }
            sum += scores[i];
                n++;

        }
        System.out.println("�󌱂����̂�" + n + "�l�ł��I");
        System.out.println("���ϓ_��" + (double) sum / n + "�_�ł��I");
        in.close();
    }
}



