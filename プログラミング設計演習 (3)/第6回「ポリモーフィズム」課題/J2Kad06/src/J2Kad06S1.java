/*
	�ۑ薼�FJ2Kad06S1�u�Ύ��Q�[���̊ȗ����v
	�쐬���F2023/10/12
	�쐬�ҁF�c�����Y
*/
import java.util.Scanner;

public class J2Kad06S1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // �����̕\��
        System.out.println("20����΂����݂Ɏ���Ă����܂��B��x�Ɏ���΂̐���1-3�ł��B");
        System.out.println("�Ō��1����������������ł��B");
        System.out.println();

        // �v���C���[�I��
        UserPlayer user = new UserPlayer();
        BasePlayer base = new BasePlayer();
        System.out.println();

        // ���ȏЉ�
        user.intro();
        base.intro();
        System.out.println();

        int	stone = 20;			// �΂̐�
        int take;				// ���΂̐�
        while(true) {
            // ���̎��
            showStone(stone);
            System.out.println(user + "�̔Ԃł��B");
            take = user.takeStone(stone);
            System.out.println(take + "���܂����I");
            stone -= take;
            if (stone <= 0) {
                System.out.println(user + "�̕����ł��I");
                break;								// while���𔲂���
            }
            System.out.println();

            // ���̎��
            showStone(stone);
            System.out.println(base + "�̔Ԃł��B");
            take = base.takeStone(stone);
            System.out.println(take + "���܂����I");
            stone -= take;
            if (stone <= 0) {
                System.out.println(base + "�̕����ł��I");
                break;								// while���𔲂���
            }
            System.out.println();
        }
    }
    public static void showStone(int stone) {
        System.out.print("�c��" + stone + "�F");
        while(stone > 0) {
            System.out.print("��");
            stone--;
        }
        System.out.println();
    }
}
