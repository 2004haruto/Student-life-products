import java.util.Scanner;

public class J2Kad24A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("���E�ɂ͂΂���ECC�t�[�Y�I");
        System.out.println("��������M&A�Ŋg�咆�I�I");

        while (true) {
            System.out.print("�ǂ̃��j���[��\�����܂����H�i0�FECC�R�[�q�[�A1�FECC�h�[�i�c�A2�FECC�o�[�K�[�A-1�F�I���j��");
            int shop = Integer.parseInt(in.next());
            if (shop < 0) break;

            Menu menu;

            switch(shop) {
                default:
                case 0:
                    menu = new CafeMenu();
                    break;
                case 1:
                    menu = new DonutMenu();
                    break;
                case 2:
                    menu = new BurgerMenu();
                    break;
            }

            // ���ʂœ�������
            MenuIterator it = menu.iterator();
            while (it.hasNext()){
                it.next().print();
            }
            System.out.println();
        }
    }
}
