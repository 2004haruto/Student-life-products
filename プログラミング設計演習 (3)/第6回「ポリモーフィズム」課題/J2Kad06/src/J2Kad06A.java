/*
	�ۑ薼�FJ2Kad06A�u�d���̏����v
	�쐬���F2023/10/12
	�쐬�ҁF�c�����Y
*/
import java.util.Scanner;

public class J2Kad06A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("�d�����������Ď��ȏЉ���܂��I");
        Fairy [] fairies = {new Fire(),new Light(),new Darkness()};
        while(true) {
            System.out.print("�ǂ����܂����H�i0�F��������A-1�F��߂�j��");
            int cmd = in.nextInt();
            if (cmd < 0) break;
            int n = (int)(Math.random() * 3);
            fairies[n].intro();
/*
            Fairy f;

            // �d���̏���
            int n = (int)(Math.random() * 3);
            switch(n) {
                default:
                case 0:
                    f = new Light();
                    break;
                case 1:
                    f = new Darkness();
                    break;
                case 2:
                    f = new Fire();
                    break;
            }

            f.intro();

 */
            System.out.println();
        }
    }
}
