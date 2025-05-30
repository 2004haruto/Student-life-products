// ガチャガチャマシーン
public class GachaMachine {

    private int count = 3;                                      // カプセル数
    public int decCount() { return --count; }                   // カプセルを減らす
    private GachaState state = new NoCoin();                    //状態。最初はNoCoin
    public void setState(GachaState state){this.state = state;} //状態を切り替える
    public void showState() {
        System.out.println("カプセルの残り：" + count);
        state.showState();
    }
    public void insertCoin() {state.insertCoin(this);}
    public void turnHandle() {state.turnHandle(this);}
    public void ejectCoin() {state.ejectCoin(this);}
}
// GachaStateインターフェイス
interface GachaState{
    void showState();
    void insertCoin(GachaMachine gm);
    void turnHandle(GachaMachine gm);
    void ejectCoin(GachaMachine gm);
}

// NoCoinクラス
class NoCoin implements GachaState{
    public void showState(){
        System.out.println("コイン：なし");
    }
    public void insertCoin(GachaMachine gm){
        System.out.println("コインを入れました！");
        gm.setState(new HasCoin());

    }
    public void turnHandle(GachaMachine gm){
        System.out.println("ハンドルが回りません！");
    }
    public void ejectCoin(GachaMachine gm){
        System.out.println("何も起こりません！");
    }
}

// HasCoinクラス
class HasCoin implements GachaState{
    public void showState(){
        System.out.println("コイン：あり");
    }
    public void insertCoin(GachaMachine gm){
        System.out.println("これ以上コインが入りません！");
    }
    public void turnHandle(GachaMachine gm){
        System.out.println("カプセルが出ました！");
        if (gm.decCount() == 0){
            gm.setState(new SoldOut());
        } else {
            gm.setState(new NoCoin());
        }
    }
    public void ejectCoin(GachaMachine gm){
        System.out.println("コインを返却しました！");
        gm.setState(new NoCoin());
    }
}

// SoldOutクラス
class SoldOut implements GachaState{
    public void showState(){
        System.out.println("売り切れ！");
    }
    public void insertCoin(GachaMachine gm){
        System.out.println("コイン投入口が閉まっています！");
    }
    public void turnHandle(GachaMachine gm){
        System.out.println("ハンドルが回りません！");
    }
    public void ejectCoin(GachaMachine gm){
        System.out.println("何も起こりません！");
    }
}
