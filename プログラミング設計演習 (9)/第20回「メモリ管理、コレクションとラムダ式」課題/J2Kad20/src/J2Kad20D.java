/*
	�ۑ薼�FJ2Kad20D�u�X�^�b�N�I�[�o�[�t���[�v
	�쐬���F2023/12/07
	�쐬�ҁF�c�����Y
*/
public class J2Kad20D {
    //throws�͎����̂Ƃ���ŃG���[���������Ȃ�
    public static void overFlow(int n) throws StackOverflowError{
        //�O�l�E��l�C���N�������g
        System.out.println(++n);
        //�ċA�Ăяo��
        overFlow(n);
    }
    public static void main(String[] args) {
        try {
            overFlow(0);
        }catch (StackOverflowError e){
            System.out.println(e);
        }
    }
}
