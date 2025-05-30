//abstractをつけて
public abstract class Subcontractor {
    String name;//会社の名前を保存
    public String getName(){
        return name;//this.nameでも可
    }

    //抽象メソッド　継承先で中身を作る
    public abstract void work();
}
