/*
	�ۑ薼�FJ2Kad24D�u���E�ɂ͂΂���ECC�t�[�Y�I�i���[�v�̕��K�j�v
	�쐬���F2023/1/11
	�쐬�ҁF�c�����Y
*/
import java.util.Scanner;

public class J2Kad24C {
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
                    CafeIterator cafeIterator = new CafeIterator(cafeMenu.getMenu());
                    //���j���[�̕\��
                    while (cafeIterator.hasNext()){
                        cafeIterator.next().print();
                    }
                    break;
                case 1:     // ECC�h�[�i�c�S���j���[�̕\��
                    DonutMenu dMenu = new DonutMenu();
                    DonutIterator dIterator = new DonutIterator(dMenu.getNames(),dMenu.getPrices());
                    while (dIterator.hasNext()){
                        dIterator.next().print();
                    }
                    break;
            }
            System.out.println();
        }
    }
}
