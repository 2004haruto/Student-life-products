public class Rocket2 extends Rocket{
    public Rocket2(int fuel,int height){
        super(fuel,height);
        System.out.println("�V�^�G���W�����I");
    }

    @Override
    public void useFuel() {
        if (fuel > 0) {
            System.out.println("�R�����g�����I");
            speed -= 7;         // �t���˂ɂ�錸��
            fuel--;
        } else {
            System.out.println("�R�����Ȃ��I");
        }
    }
}
