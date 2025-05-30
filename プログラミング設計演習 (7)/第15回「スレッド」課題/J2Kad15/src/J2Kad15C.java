/*
	課題名：J2Kad15C「スレッド②（Runnableインターフェイス）」
	作成日：2023/11/16
	作成者：田中太郎
*/
public class J2Kad15C {
    public static void main(String[] args) {
    SheepRunner sr = new SheepRunner();
    //スレッドを作って引数に渡す
        Thread thread = new Thread(sr);
        //スレッドの実行
        thread.start();
        //スレッドの実行を待つ join()を使う
        try {
            thread.join();//チェック例外、検査例外 →　絶対にtry-catchしないといけない

        }catch (InterruptedException e){
            System.out.println(e);
        }
        System.out.println("おつかれさまでした！");
    }
}
