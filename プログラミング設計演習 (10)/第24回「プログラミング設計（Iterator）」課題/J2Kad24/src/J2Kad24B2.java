/*
	�ۑ薼�FJ2Kad24D�u���E�ɂ͂΂���ECC�t�[�Y�I�i���[�v�̕��K�j�v
	�쐬���F2023/1/11
	�쐬�ҁF�c�����Y
*/
import java.util.Scanner;

public class J2Kad24B2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("���E�ɂ͂΂���ECC�t�[�Y�I");
        System.out.println("��������M&A�Ŋg�咆�I�I");

        while (true) {
            System.out.print("�ǂ̃��j���[��\�����܂����H�i0�FECC�R�[�q�[�A1�FECC�h�[�i�c�A-1�F�I���j��");
            int shop = Integer.parseInt(in.next());
            if (shop < 0) break;

            //���j���[�����ʉ����ꂽ
            Menu menu;

            switch(shop) {
                default:
                case 0:     // ECC�R�[�q�[�S���j���[�̕\��
                    menu = new CafeMenu();
                    break;
                case 1:     // ECC�h�[�i�c�S���j���[�̕\��
                    menu = new DonutMenu();
                    break;
            }
            //���ʂœ�������
            MenuIterator it = menu.iterator();
            while (it.hasNext()){
                it.next().print();
            }

//            while (menu.iterator().hasNext()){
//                menu.iterator().next().print();
//            }
            System.out.println();
        }
    }
}
