import java.util.Scanner;

public class J2Kad22B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("�t�@�~���XECC�ւ悤�����I");
        while (true) {
            System.out.print("���̃��j���[��\�����܂����H�i0�F���[�j���O�A1�F�����`�A2�F�f�B�i�[�A-1�F�I���j��");
            int n = Integer.parseInt(in.next());
            if (n < 0) break;

            // ���j���[�̕\��
            Component menu;
            if (n == 0) {
                // ���[�j���O���j���[
                menu = new MorningMenu();
            } else if (n == 1) {
                // �����`���j���[
                menu = new LunchMenu();
            } else if (n == 2) {
                // �f�B�i�[���j���[
                menu = new DinnerMenu();
            } else {
                // �����ȑI��
                continue;
            }

            menu.display();
            System.out.println();
        }
    }
}