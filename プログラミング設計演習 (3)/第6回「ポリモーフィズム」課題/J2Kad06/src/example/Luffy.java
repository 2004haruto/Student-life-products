package example;

public class Luffy extends Pirate{
    public Luffy(String name){
        super(name);
        System.out.println("�C�����ɉ��͂Ȃ�I");
    }
    @Override
    public void attack() {
        super.attack();
        System.out.println("�S���S���̏e");
    }

    public void skill(){
        System.out.println("�S���S���̉���");
    }

}
