/*
	�ۑ薼�FJ2Kad21S�u�W���u�`�F���W�I�v
	�쐬���F2023/12/12
	�쐬�ҁF�c�����Y
*/
package pac21s;

import java.util.Scanner;

public class J2Kad21S {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("���Ȃ���RPG�̃L�����N�^�[�ł��I");
        System.out.println("�����琢�E���~���`���ɏo�����܂��I");
        System.out.println("�ł����̑O�ɐE�Ƃ�I��ł��������I�I");
        System.out.println();

        RPGCharacter pc = new RPGCharacter();

        while(true) {
            System.out.println(pc + "����A����ɂ��́I");
            System.out.print("�W���u�`�F���W���܂����H�i0�F��m�A1�F���@�g���A2�F�����N�A-1�F����ł����j��");
            int n = in.nextInt();
            if (n < 0) break;
            // �W���u�`�F���W
            switch(n) {
                case 0:     pc = new Fighter();         break;
                case 1:     pc = new Mage();            break;
                case 2:     pc = new Monk();            break;
                default:    pc = new RPGCharacter();    break;
            }
            pc.attack();
            pc.defend();
            System.out.println();
        }
    }
}
