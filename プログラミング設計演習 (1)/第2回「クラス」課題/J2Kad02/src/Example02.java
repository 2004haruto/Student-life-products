public class Example02 {
    public static void main(String[] args) {
        //Adventureクラスをインスタンス化する
        //クラス型　インスタンス変数名　= new クラス型();
        Adventurer ad = new Adventurer();
        ad.name = "剣士";
        ad.hp = 30;
        ad.show();
        System.out.println(ad.name);
    }
}
