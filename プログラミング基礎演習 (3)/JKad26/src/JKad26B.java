import java.util.Scanner;

public class JKad26B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int WIN = 0;
        final int LOSE = 1;
        final int DRAW = 2;
        String[] strHands = {"�O�[", "�`���L", "�p�["};
        String[] strJudge = {"���Ȃ��̏����I", "���Ȃ��̕����I", "���������I"};
        String[][] table = {{"��������","���Ȃ��̏���","���Ȃ��̕���"},{"���Ȃ��̕���","��������","���Ȃ��̏���"},{"���Ȃ��̏���","���Ȃ��̕���","��������"}};
        while (true) {
            System.out.print("�̂ё��͉����o���܂����H�i0�F�O�[�A1�F�`���L�A2�F�p�[�A-1�F��߂�j��");
            int a = in.nextInt();
            if (a == -1)
                break;
            System.out.println("�̂ё���" + strHands[a] + "���o����!");
            int b = (int) (Math.random() * 3);
            System.out.println("��������" + strHands[b] + "���o����!");
            System.out.println();
            System.out.println(table[a][b]);
            System.out.println();
        }
    }
}
