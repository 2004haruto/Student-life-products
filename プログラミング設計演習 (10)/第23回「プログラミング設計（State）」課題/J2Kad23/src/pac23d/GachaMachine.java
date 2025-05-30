package pac23d;

public class GachaMachine {
    //アクセス修飾子は4種類
    //public　なし　protected private
    //プログラムが使える範囲を決める役割
    //カプセル化　→　関係のないプログラムからのアクセスを制限する
    //カプセル化したら外側からアクセスできない
    //→　ゲッターとセッターを作る

    private final int NO_COIN = 0;          // コインなし
    private final int HAS_COIN = 1;         // コインあり

    private final int SOLD_OUT = 2;         //売り切れの状態
    private int state = NO_COIN;            // 現在の状態（最初はコインなし）
    private int count = 3;                  // カプセル数
    public void setState(int newState) { state = newState; }    // 状態切り替え
    public int decCount() { return --count; }                   // カプセルを減らす

    //今のガチャガチャの状態の表示
    public void showState() {
        System.out.println("カプセルの残り：" + count);
        if (state == NO_COIN) {
            System.out.println("コイン：なし");
        } else if(state == HAS_COIN) {
            System.out.println("コイン：あり");
        }else if (state == SOLD_OUT) {
            System.out.println("売り切れ!");
        }
    }
    public void insertCoin() {
        if (state == NO_COIN) {
            System.out.println("コインを入れました！");
            setState(HAS_COIN);
        } else if (state == HAS_COIN) {
            System.out.println("これ以上コインが入らない！");
        }else if (state == SOLD_OUT) {
            System.out.println("コイン投入口が閉まっています！");
        }
    }
    public void turnHandle() {
        if (state == NO_COIN) {
            System.out.println("ハンドルが回りません！");
        } else if (state == HAS_COIN) {
            System.out.println("カプセルが出ました！");
            //ここで分岐する カプセルが残っているか、残っていないかで分岐する
            if (decCount() > 0){
                setState(NO_COIN);
            }else {
                setState(SOLD_OUT);
            }

        }else if (state == SOLD_OUT) {
            System.out.println("ハンドルが回りません！");
        }
    }
    public void ejectCoin() {
        if (state == NO_COIN) {
            System.out.println("何も起こりません！");
        } else if (state == HAS_COIN) {
            System.out.println("コインが返却されました！");
            setState(NO_COIN);
        }else if (state == SOLD_OUT) {
            System.out.println("何も起こりません!");
        }
    }
}
