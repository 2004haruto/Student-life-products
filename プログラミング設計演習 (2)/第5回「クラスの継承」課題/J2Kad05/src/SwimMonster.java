public class SwimMonster extends Monster{
    public SwimMonster(){
        System.out.println("SwimMonster クラスのコンストラクタが呼び出されました！");
    }
    public void swim(){
        System.out.println(super.name+"が泳ぐよ！ぶくぶく･･･");
    }
    public void walk(){
        System.out.println("尾びれだと歩けないよ～");
    }
    public void intro() {
        super.intro();
            System.out.println("泳ぎも得意さ！");

    }
}
