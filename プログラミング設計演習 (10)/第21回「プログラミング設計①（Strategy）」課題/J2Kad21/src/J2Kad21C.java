/*
	�ۑ薼�FJ2Kad21D�uECC�\�t�g������Ї@�i�Ϗ��j�v
	�쐬���F2023/12/12
	�쐬�ҁF�c�����Y
*/
import java.util.Scanner;

public class J2Kad21C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ECCSoft eccSoft = new ECCSoft();

        while(true) {
            System.out.println("�ǂ����܂����H�i0�FECC �\�t�g�Ɏd���𔭒�����A1�F��������ύX����A-1�F���������j��");            int cmd = Integer.parseInt(in.next());
            if (cmd < 0) break;

            // ECC�\�t�g���Ăяo��
            switch (cmd){
                case 0:eccSoft.work(); break;
                case 1:
                    System.out.println("�ǂ��ɂ��܂����H�i0�F�`���[���b�v����A1�F�y�[�p�[���A2�F�O���[�o�������j��");
                    int company = Integer.parseInt(in.next());
                    switch (company) {
                        case 0 -> eccSoft.setSubcontractor(new TulipCompany());
                        case 1 -> eccSoft.setSubcontractor(new PaperPlanning());
                        case 2 -> eccSoft.setSubcontractor(new GlobalTrading());
                    }
            }

            System.out.println();
        }
    }
}
