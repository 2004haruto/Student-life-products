/*
	�ۑ薼�FJ2Kad09C�u�񋓌^�@�v
	�쐬���F2023/10/24
	�쐬�ҁF�c�����Y
*/
import java.util.Scanner;

public class J2Kad09B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("����񂯂�����܂��I");

        Janken.Hand[] hands = Janken.Hand.values();
        for (Janken.Hand hand : hands){
            System.out.println(hand.name + ":\t" + hand.feature);
        }

        // ��̏Љ�
        System.out.println("�O�[" + "�F\t" + "�`���L�ɏ����āA�p�[�ɕ����܂��I");
        System.out.println("�`���L" + "�F\t" + "�p�[�����āA�O�[�ɕ����܂��I");
        System.out.println("�p�[" + "�F\t" + "�O�[�ɏ����āA�`���L�ɕ����܂��I");
        System.out.println();



        while(true) {
            // ��̑I��
            System.out.print("���������܂����H�i0�F�O�[�A1�F�`���L�A2�F�p�[�A-1�F�I���j��");
            int user = in.nextInt();
            if (user < 0) break;
            int comp = (int)(Math.random() * 3);
            // ��̕\��
            String[] strHands = {"�O�[", "�`���L", "�p�["};
            System.out.println("���Ȃ���" + hands[user].name + "���o�����I");
            System.out.println("�R���s���[�^��" + hands[comp].name + "���o�����I");

            // ���ʕ\���i�쐬���邱�Ɓj
            System.out.println(Janken.resultTbl[user][comp].msg);


            System.out.println();
        }
    }
}
