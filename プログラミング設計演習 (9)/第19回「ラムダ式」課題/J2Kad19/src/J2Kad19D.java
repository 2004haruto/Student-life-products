/*
	�ۑ薼�FJ2Kad19D�u�����N���X�v
	�쐬���F2023/12/05
	�쐬�ҁF�c�����Y
*/
// SayHello�C���^�[�t�F�C�X


// Greeting�N���X


// OuterPerson�N���X


public class J2Kad19D {
    public static void main(String[] args) {
        //SayHello�C���^�[�t�F�[�X�̎Q�Ƃ��g����OuterPerson�𐶐�
        SayHello outer = new OuterPerson();
        //static����̃��\�b�h�̓N���X��.���\�b�h()�ŌĂяo����
        Greeting.greet(outer);

        //InnerPerson�N���X���쐬����(�d�l��OuterPerson�N���X�Ɠ���)
        class InnerPerson implements SayHello{
            public void hello(){
                System.out.println("�����N���X�F����ɂ��́I");
            }
        }
        SayHello inner = new InnerPerson();
        Greeting.greet(inner);
    }

}

class  Greeting{
    //SayHello�^�̃C���X�^���X�������Ɏ󂯎���Ă���
    public static void greet(SayHello s){
        s.hello();
    }
}

class OuterPerson implements SayHello{
    public void hello(){
        System.out.println("�O���N���X�F����ɂ��́I");
    }
}
