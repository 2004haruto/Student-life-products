/*
	�ۑ薼�FJ2Kad05X�uECC�����Z���^�[�A�v
	�쐬���F2023/10/10
	�쐬�ҁF�c�����Y
*/
import java.util.Scanner;

public class J2Kad15X {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("������ECC�����Z���^�[�ł��I");
        System.out.println("�D�G�ȃX�^�b�t���Ή����܂��I");
        System.out.println();

        Nobita nobita = new Nobita();
        Jaian jaian = new Jaian();
        Suneo suneo = new Suneo();
        Dekisugi dekisugi = new Dekisugi();
        System.out.println();

        while(true) {
            int n = (int)(Math.random() * 100);
            System.out.println("���ԍ��F" + n + "���󂯕t�����I");
            System.out.print("�ǂ����܂����H�i1�F�Ή�����A����ȊO�F�����₾�j��");
            int cmd = in.nextInt();
            if (cmd != 1) break;

            if (!nobita.handle(n)) {
                if (!jaian.handle(n)) {
                    if (!suneo.handle(n)) {
                        dekisugi.handle(n);
                    }
                }
            }
            System.out.println();
        }
        System.out.println("�����ꂳ�܂ł����I");
        in.close();
    }
}
