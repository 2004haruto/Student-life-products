public class RockMonster extends Monster{
    public RockMonster(String name){
        super(name);
    }
    public void defend(){
        System.out.println(name + "〜は防御している！ダメージを与えられない!!");
    }
    public void intro(){
        super.intro();
        System.out.println("とても硬いぜ！");
    }
}
