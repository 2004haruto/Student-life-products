public class RockMonster extends Monster{
    public RockMonster(String name){
        super(name);
    }
    public void defend(){
        System.out.println(name + "�`�͖h�䂵�Ă���I�_���[�W��^�����Ȃ�!!");
    }
    public void intro(){
        super.intro();
        System.out.println("�ƂĂ��d�����I");
    }
}
