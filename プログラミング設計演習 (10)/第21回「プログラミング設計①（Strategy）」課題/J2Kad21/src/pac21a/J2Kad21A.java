package pac21a;

import java.util.Scanner;

public class J2Kad21A {
    public static void main(String[] args) {
        FamiredoComputer famiredoComputer = new FamiredoComputer();
        Scanner scanner = new Scanner(System.in);

        System.out.println("�t�@�~�R���𔃂��Ă�������I");
        System.out.println("�Q�[���\�t�g�������Ă�������I");

        while (true) {
            System.out.println("�ǂ����܂����H�i0�F�V�ԁA1�F�J�Z�b�g���Z�b�g����A-1�F1 ���ԗV�񂾂̂ł�߂�j��");
            int choice = scanner.nextInt();

            if (choice == -1) {
                break;
            } else if (choice == 0) {
                famiredoComputer.play();
            } else if (choice == 1) {
                System.out.println("�ǂ���Z�b�g���܂����H�i0�F�}���I�A1�F�[���_�A2�F�X�}�u���A3�F�J�Z�b�g�����O���j��");
                int gameChoice = scanner.nextInt();

                FCCassette cassette = null;
                switch (gameChoice) {
                    case 0:
                        cassette = new FCMario();
                        break;
                    case 1:
                        cassette = new FCZelda();
                        break;
                    case 2:
                        cassette = new FCSmash();
                        break;
                    case 3:
                        famiredoComputer.removeCassette();
                        break;
                    default:
                        System.out.println("�����ȑI���ł��B");
                        break;
                }

                if (cassette != null) {
                    famiredoComputer.setCassette(cassette);
                }
            }
        }
    }
}