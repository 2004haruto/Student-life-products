/*
    �ۑ薼�FJ2Kad23A�u�K�`���K�`���}�V�[�������I�v
    �쐬���F2024/1/9
    �쐬�ҁF�c�����Y
*/
import java.util.Scanner;

public class J2Kad23A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("�K�`���K�`�������܂��I");

        GachaMachine gm = new GachaMachine();
        while(true) {
            gm.showState();
            System.out.print("�ǂ����܂����H�i0�F�R�C��������A1�F�n���h�����񂷁A2�F�ԋp�{�^���������A-1�F�I���j��");
            int cmd = Integer.parseInt(in.next());
            if (cmd < 0) break;

            switch(cmd) {
                case 0: gm.insertCoin();   break;
                case 1: gm.turnHandle();   break;
                case 2: gm.ejectCoin();    break;
            }
        }
    }
}