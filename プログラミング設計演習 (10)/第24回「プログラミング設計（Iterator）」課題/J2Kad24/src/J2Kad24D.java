/*
	�ۑ薼�FJ2Kad24D�u���E�ɂ͂΂���ECC�t�[�Y�I�i���[�v�̕��K�j�v
	�쐬���F2023/1/11
	�쐬�ҁF�c�����Y
*/
import java.util.Scanner;

public class J2Kad24D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("���E�ɂ͂΂���ECC�t�[�Y�I");
        System.out.println("��������M&A�Ŋg�咆�I�I");

        while (true) {
            System.out.print("�ǂ̃��j���[��\�����܂����H�i0�FECC�R�[�q�[�A1�FECC�h�[�i�c�A-1�F�I���j��");
            int shop = Integer.parseInt(in.next());
            if (shop < 0) break;

            switch(shop) {
                default:
                case 0:     // ECC�R�[�q�[�S���j���[�̕\��
                    CafeMenu cafeMenu = new CafeMenu();
                    MenuItem[] menu = cafeMenu.getMenu(); //���j���[�̑��
                    //for���Ŏ��o��
                    for (int i = 0;menu[i] != null;i++){
                        menu[i].print();
                    }
                    break;
                case 1:     // ECC�h�[�i�c�S���j���[�̕\��
                    DonutMenu dmenu = new DonutMenu();
                    String[] names = dmenu.getNames();
                    int[] prices = dmenu.getPrices();
                    for (int i = 0;prices[i] != -1;i++){
                        System.out.println(names[i]+":"+prices[i]);
                    }
                    break;
            }
            System.out.println();
        }
    }
}
