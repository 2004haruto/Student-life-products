public class FireMonster extends Monster{
    public FireMonster(String name){
        super(name);
    }
    public void fire(){
        System.out.println(name+ "�͉����͂����I�S�I�`�I�I");
    }
    public void intro(){
        super.intro();
        System.out.println("�����o�����I");
    }
}
