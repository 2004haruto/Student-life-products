/*
	�ۑ薼�FJ2Kad15C�u�X���b�h�A�iRunnable�C���^�[�t�F�C�X�j�v
	�쐬���F2023/11/16
	�쐬�ҁF�c�����Y
*/
public class J2Kad15C {
    public static void main(String[] args) {
    SheepRunner sr = new SheepRunner();
    //�X���b�h������Ĉ����ɓn��
        Thread thread = new Thread(sr);
        //�X���b�h�̎��s
        thread.start();
        //�X���b�h�̎��s��҂� join()���g��
        try {
            thread.join();//�`�F�b�N��O�A������O ���@��΂�try-catch���Ȃ��Ƃ����Ȃ�

        }catch (InterruptedException e){
            System.out.println(e);
        }
        System.out.println("�����ꂳ�܂ł����I");
    }
}
