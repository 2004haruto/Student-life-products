/*
	�ۑ薼�FJ2Kad24X�u���E�ɂ͂΂���ECC�t�[�Y�I�i�g��for���Ή��j�v
	�쐬���F2023/1/11
	�쐬�ҁF�c�����Y
*/
package pac24x;

import java.util.Scanner;

public class J2Kad24X {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("���E�ɂ͂΂���ECC�t�[�Y�I");
        System.out.println("��������M&A�Ŋg�咆�I�I");

        while (true) {
            System.out.print("�ǂ̃��j���[��\�����܂����H�i0�FECC�R�[�q�[�A1�FECC�h�[�i�c�A2�FECC�o�[�K�[�A-1�F�I���j��");
            int shop = Integer.parseInt(in.next());
            if (shop < 0) break;

            switch(shop) {
                default:
                case 0:     // ECC�R�[�q�[
                    CafeMenu cafe = new CafeMenu();
                    MenuItem[] menu = cafe.getMenu();
                    for (int i = 0; menu[i] != null; i++) {
                        menu[i].print();
                    }
                    break;
                case 1:     // ECC�h�[�i�c
                    DonutMenu donut = new DonutMenu();
                    String[] names = donut.getNames();
                    int[] prices = donut.getPrices();
                    for (int i = 0; prices[i] != -1; i++) {
                        MenuItem item = new MenuItem(names[i], prices[i]);
                        item.print();
                    }
                    break;
                case 2:     // ECC�o�[�K�[
                    BurgerMenu burger = new BurgerMenu();
                    for (var item : burger.getMenu()) {
                        item.print();
                    }
                    break;
            }
            System.out.println();
        }
    }
}
