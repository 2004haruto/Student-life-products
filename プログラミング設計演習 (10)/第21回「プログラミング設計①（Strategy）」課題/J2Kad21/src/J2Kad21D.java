/*
	�ۑ薼�FJ2Kad21D�uECC�\�t�g������Ї@�i�Ϗ��j�v
	�쐬���F2023/12/12
	�쐬�ҁF�c�����Y
*/
import java.util.Scanner;

public class J2Kad21D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ECCSoft eccSoft = new ECCSoft();

        while(true) {
            System.out.print("�ǂ����܂����H�i0�FECC�\�t�g�Ɏd���𔭒�����A-1�F���������j��");
            int cmd = Integer.parseInt(in.next());
            if (cmd < 0) break;

            // ECC�\�t�g�֎d���𔭒�����
            eccSoft.work();

            System.out.println();
        }
    }
}
