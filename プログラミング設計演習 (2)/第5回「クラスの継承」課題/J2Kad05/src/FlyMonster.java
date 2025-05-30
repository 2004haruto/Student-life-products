public class FlyMonster extends Monster{
    public FlyMonster(){
        System.out.println("FlyMonster クラスのコンストラクタが呼び出されました！");
    }
    public void fly(){
        System.out.println(super.name + "が飛ぶよ！びゅ～ん!!");
    }
}
