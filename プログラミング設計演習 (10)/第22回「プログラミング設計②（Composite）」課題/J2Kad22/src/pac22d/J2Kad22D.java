package pac22d;

import java.util.Scanner;

public class J2Kad22D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("�t�@�~���XECC�ւ悤�����I");
        while (true) {
            System.out.print("�ǂ����܂����H�i0�F�P�i�\���A1�F�ꗗ�\���A-1�F�I���j��");
            int n = Integer.parseInt(in.next());
            if (n < 0) break;

            // ���j���[�̕\��
            if (n == 0) {
                // �P�i�\��
                MenuItem morningSet = new MenuItem("���[�j���O�Z�b�g", 400);
                morningSet.printItem();
            } else if (n == 1) {
                // �ꗗ�\��
                MorningMenu morningMenu = new MorningMenu();
                morningMenu.printList();
            }

            System.out.println();
        }
    }
}
