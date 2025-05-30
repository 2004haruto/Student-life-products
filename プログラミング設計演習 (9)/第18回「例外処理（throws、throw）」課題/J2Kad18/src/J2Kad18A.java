/*
	�ۑ薼�FJ2Kad18A�uECC�싅���I�v
	�쐬���F2023/11/30
	�쐬�ҁF�c�����Y
*/
import java.io.BufferedReader;
import java.util.Scanner;

public class J2Kad18A {
    enum BALL {STRAIGHT, CURVE, FORKBALL}
    public static void main(String[] args) {
        System.out.println("���Ȃ���ECC�싅���̖��L���b�`���[�ł��I");
        System.out.println("�T�C�����o���ăs�b�`���[�̋����L���b�`���Ă��������I");

        Scanner in = new Scanner(System.in);
        BALL[] balls = BALL.values();//enum�̒l��z��ɓ����

        while(true) {
            try {
            System.out.print("���̃T�C�����o���܂����H�i0�F�����A1�F�J�[�u�A2�F�t�H�[�N�A-1�F�I���j��");
            int n = Integer.parseInt(in.next());
            //������n�����ł͖����B�{�[���^��n���K�v������
            throwBall(balls[n]);
        }catch (Ball e) {
                System.out.println(e);
                System.out.println("�L���b�`���܂����I");
        }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("����ȋ���͂���܂���I");
        }
        System.out.println();
        }
    }

    //Ball�ł܂Ƃ߂Ă����Ɗy
    public static void throwBall(BALL ball) throws Ball{
        switch (ball){
            case STRAIGHT : throw new Straight();
            case CURVE: throw new Curve();
            case FORKBALL: throw new ForkBall();
        }
    }
}
//�X�g���[�g�A�J�[�u�A�t�H�[�N�̐e�N���X(��O)�����
class Ball extends Exception{
    public Ball(String msg){
        super(msg);
    }
}
//�X�g���[�g�̗�O
class Straight extends Ball {
    public Straight(){
        super("�X�g���[�g�𓊂����I");
    }
}
//�J�[�u�̗�O
class Curve extends Ball{
    public Curve(){
        super("�J�[�u�𓊂����I");
    }
}
//�t�H�[�N�̗�O
class ForkBall extends Ball{
    public ForkBall(){
        super("�t�H�[�N�{�[���𓊂����I");
    }
}