/*
	�ۑ薼�FJ2Kad21B�u�X�[�p�[�R���s���[�^ECC1000�v
	�쐬���F2023/12/12
	�쐬�ҁF�c�����Y
*/
package pac21b;

import java.util.Scanner;

public class J2Kad21B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("�X�[�p�[�R���s���[�^ECC1000���J�������I");
        System.out.println("�A���S���Y�����Z�b�g����΂ǂ�ȍ��x�Ȍv�Z�ł��ł��܂��I�I");

        ECC1000 ecc1000 = new ECC1000();

        while(true) {
            System.out.print("�v�Z�A���S���Y�����Z�b�g���Ă��������i0�FNobita�A1�FSuneo�A2�FDekisugi�A3�FSizuka�A-1�F�I���j��");
            int algNum = Integer.parseInt(in.next());
            if (algNum < 0) break;

            // �A���S���Y���̑I��


            // ���Z


            System.out.println();
        }
    }
}
