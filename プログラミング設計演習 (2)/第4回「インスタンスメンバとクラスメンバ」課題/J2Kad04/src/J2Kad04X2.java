/*
    �ۑ薼�FJ2Kad04X2�u���W�҂��s��A�v
    �쐬���F2023/10/05
    �쐬�ҁF�c�����Y
 */
import java.util.Scanner;

public class J2Kad04X2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("��������Ⴂ�I�����X�[�p�[ECC2���X�ł��I�I");
        Stack line = new Stack(5);

        while(true) {
            // �f�[�^�̕\��
            if (!line.empty()) {
                System.out.println("���݂̃��W�҂��s��ł��I");
                for (int i = 0; i < line.size(); i++) {
                    System.out.println(i + "�F" + line.get(i));
                }
                System.out.println();
            }

            // �R�}���h�I��
            System.out.print("�������܂����H�i0�F�q���Ăэ��ށA1�F���W��łA-1�F�X�������ށj��");
            int cmd = in.nextInt();
            if (cmd < 0) break;

            switch (cmd) {
                case 0:			// �q���Ăэ���
                    Monster	m = new Monster();
                    if (line.full()) {
                        System.out.println("�����X�ɓ���Ȃ��I�c�O�I�I");
                    }
                    else {
                        line.push(m);
                    }
                    break;
                case 1:			// ���W��ł�
                    if (line.empty()) {
                        System.out.println("���q���񂪂��Ȃ��I�I");
                    }
                    else {
                        System.out.println(line.pop() + "�͋A���Ă������I�I");
                    }
                    break;
            }
            System.out.println();
        }
        System.out.println();
    }
}
