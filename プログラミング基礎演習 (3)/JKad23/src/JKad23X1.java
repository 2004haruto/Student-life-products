import java.util.Scanner;

public class JKad23X1 {
    public static void main(String[] args) {
        final int gu= 0;
        final int choki= 1;
        final int pa= 2;
        //��̌���
        Scanner in = new Scanner(System.in);
        int random = (int) (Math.random() * 3);
        System.out.println("����񂯂�����܂��I");
        System.out.print("���̎���o���܂����H�i0�F�O�[�A1�F�`���L�A2�F�p�[�j��");
        int a = in.nextInt();
        //��̕\��
        String [] strHand = {"�O�[","�`���L","�p�["};
        System.out.println("���Ȃ���"+strHand[a]+"���o�����I");
        System.out.println("CPU��"+strHand[random]+"���o�����I");
        //����

        switch (a) {
            case gu:
                switch (random) {
                    case gu:
                        System.out.println("���������I");
                        break;
                    case choki:
                        System.out.println("���Ȃ��̏����I");
                        break;
                    case pa:
                        System.out.println("���Ȃ��̕����I");
                        break;
                }
                break;
            case choki:
                switch (random) {
                    case gu:
                        System.out.println("���Ȃ��̕����I");
                        break;
                    case choki:
                        System.out.println("���������I");
                        break;
                    case pa:
                        System.out.println("���Ȃ��̏����I");
                        break;
                }
                break;
            case pa:
                switch (random) {
                    case gu:
                        System.out.println("���Ȃ��̏����I");
                        break;
                    case choki:
                        System.out.println("���Ȃ��̕����I");
                        break;
                    case pa:
                        System.out.println("���������I");
                        break;
                }
                break;
            }
    }
}
