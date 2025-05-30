import java.util.Scanner;

public class JKad26A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int kisi = 0;
        final int yumi = 1;
        final int yari = 2;
        final int syogun = 3;
        final int supai = 4;
        String[] strHands = {"�R�m", "�|��", "����","���R","�X�p�C"};
        String[] strJudge = {"���Ȃ��̏����I", "���Ȃ��̕����I", "���������I"};
        String[][] table = {{"��������","���Ȃ��̏���","���Ȃ��̕���","���Ȃ��̕����I","���Ȃ��̏����I"},{"���Ȃ��̕���","��������","���Ȃ��̏���","���Ȃ��̕����I","���Ȃ��̏����I"},{"���Ȃ��̏���","���Ȃ��̕���","��������","���Ȃ��̕����I","���Ȃ��̏����I"},{"���Ȃ��̏����I","���Ȃ��̏����I","���Ȃ��̏����I","���������I","���Ȃ��̕����I"},{"���Ȃ��̕����I","���Ȃ��̕����I","���Ȃ��̕����I","���Ȃ��̏����I","���������I"}};
        while (true) {
            System.out.print("�̂ё��͉����o���܂����H�i0�F�R�m�A1�F�|���A2�F�����A3�F���R�A4�F�X�p�C�A-1�F��߂�j��");
            int a = in.nextInt();
            if (a == -1)
                break;
            System.out.println("�̂ё���" + strHands[a] + "���o����!");
            int b = (int) (Math.random() * 5);
            System.out.println("��������" + strHands[b] + "���o����!");
            System.out.println();
            System.out.println(table[a][b]);
            System.out.println();
        }
    }
}
