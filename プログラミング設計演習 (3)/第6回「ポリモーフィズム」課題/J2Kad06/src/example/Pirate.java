package example;

public class Pirate {
    private String name;  //名前
    //コンストラクタ
    public Pirate(String name){
        this.name = name;
    }
    //攻撃用のメソッド
    public void attack(){
        System.out.println("攻撃");
    }
}
