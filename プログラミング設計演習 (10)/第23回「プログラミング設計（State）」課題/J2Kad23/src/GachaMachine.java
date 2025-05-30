// �K�`���K�`���}�V�[��
public class GachaMachine {

    private int count = 3;                                      // �J�v�Z����
    public int decCount() { return --count; }                   // �J�v�Z�������炷
    private GachaState state = new NoCoin();                    //��ԁB�ŏ���NoCoin
    public void setState(GachaState state){this.state = state;} //��Ԃ�؂�ւ���
    public void showState() {
        System.out.println("�J�v�Z���̎c��F" + count);
        state.showState();
    }
    public void insertCoin() {state.insertCoin(this);}
    public void turnHandle() {state.turnHandle(this);}
    public void ejectCoin() {state.ejectCoin(this);}
}
// GachaState�C���^�[�t�F�C�X
interface GachaState{
    void showState();
    void insertCoin(GachaMachine gm);
    void turnHandle(GachaMachine gm);
    void ejectCoin(GachaMachine gm);
}

// NoCoin�N���X
class NoCoin implements GachaState{
    public void showState(){
        System.out.println("�R�C���F�Ȃ�");
    }
    public void insertCoin(GachaMachine gm){
        System.out.println("�R�C�������܂����I");
        gm.setState(new HasCoin());

    }
    public void turnHandle(GachaMachine gm){
        System.out.println("�n���h�������܂���I");
    }
    public void ejectCoin(GachaMachine gm){
        System.out.println("�����N����܂���I");
    }
}

// HasCoin�N���X
class HasCoin implements GachaState{
    public void showState(){
        System.out.println("�R�C���F����");
    }
    public void insertCoin(GachaMachine gm){
        System.out.println("����ȏ�R�C��������܂���I");
    }
    public void turnHandle(GachaMachine gm){
        System.out.println("�J�v�Z�����o�܂����I");
        if (gm.decCount() == 0){
            gm.setState(new SoldOut());
        } else {
            gm.setState(new NoCoin());
        }
    }
    public void ejectCoin(GachaMachine gm){
        System.out.println("�R�C����ԋp���܂����I");
        gm.setState(new NoCoin());
    }
}

// SoldOut�N���X
class SoldOut implements GachaState{
    public void showState(){
        System.out.println("����؂�I");
    }
    public void insertCoin(GachaMachine gm){
        System.out.println("�R�C�����������܂��Ă��܂��I");
    }
    public void turnHandle(GachaMachine gm){
        System.out.println("�n���h�������܂���I");
    }
    public void ejectCoin(GachaMachine gm){
        System.out.println("�����N����܂���I");
    }
}
