import java.util.Scanner;

public class JKad26C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            int a = 0;
            System.out.print("�̂ё��͉����o���܂����H�i0�F�O�[�A1�F�`���L�A2�F�p�[�A-1�F��߂�j��");
            a = in.nextInt();
            if (a == -1)
                break;
                String[] strHands = {"�O�[", "�`���L", "�p�["};
                System.out.println("�̂ё���" + strHands[a] + "���o����!");
                int b = (int) (Math.random() * 3);
                System.out.println("��������" + strHands[b] + "���o����!");
        }
    }
}
