public class FireMonster extends Monster{
    public FireMonster(String name){
        super(name);
    }
    public void fire(){
        System.out.println(name+ "は炎をはいた！ゴオ～！！");
    }
    public void intro(){
        super.intro();
        System.out.println("炎も出せるよ！");
    }
}
