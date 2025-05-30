//すでにextendsしているのでThreadは継承できない
//解決策　→　Runnableインターフェースの実装

public class SheepRunner extends Sheep implements Runnable{

    //コンストラクタ これは書かなくてもよい
    //引数なしのコンストラクタ　→　デフォルトコンストラクタ
    public SheepRunner(){
        //親クラスのコンストラクタ呼び出し
        super();
    }
    //インターフェースの中のメソッドは原則、抽象メソッド
    //抽象メソッドは中身のないメソッド→強制的にオーバーライドしないといけない
    public void run(){
        //継承しているのでsheepクラスのnameを使える
        System.out.println(name + "が走ります！");

        for (int i = 100; i > 0;i--){
            System.out.println(name + ":残り" + i + "メートル");
        }
        System.out.println(name + ":ゴールしました！");
    }
}
