/*
	�ۑ薼�FJ2Kad08D�u���ۃN���X�ƃC���^�[�t�F�C�X�v
	�쐬���F2023/10/19
	�쐬�ҁF�c�����Y
*/
import java.util.Scanner;

public class J2Kad08D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("�d�����������Ď��ȏЉ���܂��I");

        while(true) {
            System.out.print("�N���������܂����H�i0�F���̗d���A1�F�ł̗d���A2�F���̗d���A-1�F��߂�j��");
            int n = in.nextInt();
            if (n < 0) break;

            switch(n) {
                default:
                case 0:
                    Light light = new Light();
                    light.intro();
                    break;
                case 1:
                    Darkness dark = new Darkness();
                    dark.intro();
                    break;
                case 2:
                    Fire fire = new Fire();
                    fire.intro();
                    break;
            }

            System.out.println();
        }
    }
}
