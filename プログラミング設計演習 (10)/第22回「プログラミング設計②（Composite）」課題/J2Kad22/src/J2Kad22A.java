import java.util.Scanner;

// AllMenu �N���X
class AllMenu extends MenuList {
    public AllMenu() {
        super("������ ���ׂẴ��j���[ ������");

        // ���[�j���O���j���[��ǉ�
        MorningMenu morningMenu = new MorningMenu();
        add(morningMenu);

        // �����`���j���[��ǉ�
        LunchMenu lunchMenu = new LunchMenu();
        add(lunchMenu);

        // �f�B�i�[���j���[��ǉ�
        DinnerMenu dinnerMenu = new DinnerMenu();
        add(dinnerMenu);
    }
}

public class J2Kad22A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("�t�@�~���XECC�ւ悤�����I");
        while (true) {
            System.out.print("���̃��j���[��\�����܂����H�i0�F���[�j���O�A1�F�����`�A2�F�f�B�i�[�A3�F���ׂāA-1�F�I���j��");
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
            } else if (n == 3) {
                // ���ׂẴ��j���[
                menu = new AllMenu();
            } else {
                // �����ȑI��
                continue;
            }

            menu.display();
            System.out.println();
        }
    }
}
