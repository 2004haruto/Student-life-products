/*
	�ۑ薼�Fpac23S.J2Kad23S�u�X�g�b�v�E�H�b�`�I�iState�p�^�[���Łj�v
	�쐬���F2024/1/9
	�쐬�ҁF�c�����Y
*/
package pac23s;

import java.util.Scanner;

public class J2Kad23S {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StopWatch sw = new StopWatch();
        while(true) {
            sw.showState();
            System.out.print("�ǂ����܂����H�i0�FSTART�A1�FCLEAR�A-1�F�I���j��");
            int cmd = Integer.parseInt(in.next());
            if (cmd < 0) break;

            switch(cmd) {
                case 0:     sw.start();      break;
                case 1:     sw.clear();      break;
                default:    sw.noAction();   break;
            }
        }
    }
}
