/*
	�ۑ薼�FJ2Kad06B�u���ʒ����Q�[���I�B�i���P�b�g�I���j�v
	�쐬���F2023/10/12
	�쐬�ҁF�c�����Y
*/
import java.util.Scanner;

public class J2Kad06B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("���ʒ����Q�[���I");
        System.out.println("���P�b�g�𑀂��Ė����������Ă��������B");
		System.out.println("���x��0�ȉ��ɂȂ����璅���ł��B");
		System.out.println("�������A�������x��10���z���Ă���ƃ��P�b�g�͕��X�ɂȂ�܂��B");
		System.out.println("���܂��t���˂��āA�������Ă��������B");
		System.out.println();

        System.out.print("�g�p���郍�P�b�g��I�����Ă��������i1�F���^�A����ȊO�F�V�^�j��");
        int rocketChoice = in.nextInt();
        Rocket r ;
        if(rocketChoice == 1){
            r = new Rocket(15,300);
        }else {
            r = new Rocket2(15,300);
        }

        while(true) {
            r.showData();
            if (r.getHeight() <= 0) break;
            // �R�}���h����
            System.out.print("�t���˂��܂����H�i1�F����A����ȊO�F���Ȃ��j��");
            int cmd = in.nextInt();
            if (cmd == 1) r.useFuel();
            r.move();
            System.out.println();
        }

        // ���ʔ���
        if ( r.getSpeed() > 10 ) {
            System.out.println("�Y�L���[���I�������s�I�I");
        } else {
            System.out.println("���߂łƂ��I���������I�I");
        }
        in.close();
    }
}
