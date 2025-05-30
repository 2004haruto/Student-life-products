/*
	課題名：J2Kad20D「スタックオーバーフロー」
	作成日：2023/12/07
	作成者：田中太郎
*/
public class J2Kad20D {
    //throwsは自分のところでエラー処理をしない
    public static void overFlow(int n) throws StackOverflowError{
        //前値・後値インクリメント
        System.out.println(++n);
        //再帰呼び出し
        overFlow(n);
    }
    public static void main(String[] args) {
        try {
            overFlow(0);
        }catch (StackOverflowError e){
            System.out.println(e);
        }
    }
}
