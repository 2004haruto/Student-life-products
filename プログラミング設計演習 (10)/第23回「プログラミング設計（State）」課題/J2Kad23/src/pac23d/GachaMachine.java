package pac23d;

public class GachaMachine {
    //�A�N�Z�X�C���q��4���
    //public�@�Ȃ��@protected private
    //�v���O�������g����͈͂����߂����
    //�J�v�Z�����@���@�֌W�̂Ȃ��v���O��������̃A�N�Z�X�𐧌�����
    //�J�v�Z����������O������A�N�Z�X�ł��Ȃ�
    //���@�Q�b�^�[�ƃZ�b�^�[�����

    private final int NO_COIN = 0;          // �R�C���Ȃ�
    private final int HAS_COIN = 1;         // �R�C������

    private final int SOLD_OUT = 2;         //����؂�̏��
    private int state = NO_COIN;            // ���݂̏�ԁi�ŏ��̓R�C���Ȃ��j
    private int count = 3;                  // �J�v�Z����
    public void setState(int newState) { state = newState; }    // ��Ԑ؂�ւ�
    public int decCount() { return --count; }                   // �J�v�Z�������炷

    //���̃K�`���K�`���̏�Ԃ̕\��
    public void showState() {
        System.out.println("�J�v�Z���̎c��F" + count);
        if (state == NO_COIN) {
            System.out.println("�R�C���F�Ȃ�");
        } else if(state == HAS_COIN) {
            System.out.println("�R�C���F����");
        }else if (state == SOLD_OUT) {
            System.out.println("����؂�!");
        }
    }
    public void insertCoin() {
        if (state == NO_COIN) {
            System.out.println("�R�C�������܂����I");
            setState(HAS_COIN);
        } else if (state == HAS_COIN) {
            System.out.println("����ȏ�R�C��������Ȃ��I");
        }else if (state == SOLD_OUT) {
            System.out.println("�R�C�����������܂��Ă��܂��I");
        }
    }
    public void turnHandle() {
        if (state == NO_COIN) {
            System.out.println("�n���h�������܂���I");
        } else if (state == HAS_COIN) {
            System.out.println("�J�v�Z�����o�܂����I");
            //�����ŕ��򂷂� �J�v�Z�����c���Ă��邩�A�c���Ă��Ȃ����ŕ��򂷂�
            if (decCount() > 0){
                setState(NO_COIN);
            }else {
                setState(SOLD_OUT);
            }

        }else if (state == SOLD_OUT) {
            System.out.println("�n���h�������܂���I");
        }
    }
    public void ejectCoin() {
        if (state == NO_COIN) {
            System.out.println("�����N����܂���I");
        } else if (state == HAS_COIN) {
            System.out.println("�R�C�����ԋp����܂����I");
            setState(NO_COIN);
        }else if (state == SOLD_OUT) {
            System.out.println("�����N����܂���!");
        }
    }
}
