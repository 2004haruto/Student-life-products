/*
    �ۑ薼�FJ2Kad03A�u�X�^�b�N�I�B�v
    �쐬���F2023/10/03
    �쐬�ҁF�c�����Y
 */
import java.util.Scanner;

public class J2Kad03A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("�X�^�b�N��������܂��I");
        Stack s = new Stack();
        s.stack = new int[10];  // �X�^�b�N�T�C�Y�̐ݒ�
        s.sp = 0;               // �X�^�b�N�|�C���^�i�ŏ���0�j

        while(true) {
            System.out.print("�ǂ����܂����H�i1�Fpush�A2�Fpop�A-1�F�I���j��");
            int cmd = in.nextInt();
            if (cmd < 0) break;

            switch(cmd) {
                case 1:
                    if (s.sp >= s.stack.length) {
                        System.out.println("�X�^�b�N�������ς��ł��I");
                    } else {
                        s.push((int)(Math.random() *100));
                    }
                    break;
                case 2:
                    if (s.sp <= 0) {
                        System.out.println("�f�[�^������܂���I");
                    } else {
                        System.out.println(s.pop() + "�����o���܂����I");
                    }
                    break;
            }

            System.out.print("stack�F");
            for (int i = 0; i < s.sp; i++) {
                System.out.print(s.stack[i] + " ");
            }
            System.out.println();
            System.out.println();
        }
    }
}