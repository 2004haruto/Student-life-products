/*
    �ۑ薼�FJ2Kad23C�u��ԃN���X�v
    �쐬���F2024/1/9
    �쐬�ҁF�c�����Y
*/
import java.util.Scanner;

public class J2Kad23C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("�K�`���K�`�������܂��I");

        GachaMachine gm = new GachaMachine();
        GachaState gs = null;
        while(true) {
            System.out.print("�ǂ̏�Ԃ��`�F�b�N���܂����H�i0�FNoCoin�A1�FHasCoin�A-1�F�I���j��");
            int n = Integer.parseInt(in.next());
            if (n < 0) break;

            // �I��������ԃN���X�𐶐����e���\�b�h�����s����
            switch(n) {
                case 0: gs = new NoCoin();   break;
                case 1: gs = new HasCoin();   break;
            }
            if (gs != null){
                gs.showState();
                gs.insertCoin(gm);
                gs.turnHandle(gm);
                gs.ejectCoin(gm);
            }
            System.out.println();
        }
    }
}