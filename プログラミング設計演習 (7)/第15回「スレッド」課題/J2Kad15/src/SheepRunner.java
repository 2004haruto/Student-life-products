//���ł�extends���Ă���̂�Thread�͌p���ł��Ȃ�
//������@���@Runnable�C���^�[�t�F�[�X�̎���

public class SheepRunner extends Sheep implements Runnable{

    //�R���X�g���N�^ ����͏����Ȃ��Ă��悢
    //�����Ȃ��̃R���X�g���N�^�@���@�f�t�H���g�R���X�g���N�^
    public SheepRunner(){
        //�e�N���X�̃R���X�g���N�^�Ăяo��
        super();
    }
    //�C���^�[�t�F�[�X�̒��̃��\�b�h�͌����A���ۃ��\�b�h
    //���ۃ��\�b�h�͒��g�̂Ȃ����\�b�h�������I�ɃI�[�o�[���C�h���Ȃ��Ƃ����Ȃ�
    public void run(){
        //�p�����Ă���̂�sheep�N���X��name���g����
        System.out.println(name + "������܂��I");

        for (int i = 100; i > 0;i--){
            System.out.println(name + ":�c��" + i + "���[�g��");
        }
        System.out.println(name + ":�S�[�����܂����I");
    }
}
