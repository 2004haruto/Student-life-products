/*
	課題名：J2Kad14B「ECC長屋、恐怖の3号室！」
	作成日：2023/11/14
	作成者：田中太郎
*/
import java.util.InputMismatchException;
import java.util.Scanner;

public class J2Kad14B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Sheep[] nagaya = new Sheep[] { new Sheep(), new Sheep(), new Sheep() };
        String n= "0"; //外側で宣言
        while(true) {
            try {
                System.out.print("何号室を見ますか？（-1：興味なし）＞");
                //ラッパークラス
                //基本データ型をオブジェクトにしたやつ
                n = in.next();//入力を文字列で受け取る
                //文字列を数字に変換
                int num = Integer.parseInt(n);
                if (num < 0) break;
                nagaya[num].intro();
                System.out.println();
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("配列の部屋数は3 やけど、部屋番号は0 から始まるから、0 号室・1 号室・2 号室までしかないねん。"+n+" 号室はないって何回ゆうたらわかんねん？");
            }catch (NumberFormatException nfe){
                //InputMismatchException → NumberFormatException に変更
                System.out.println("部屋番号は整数やって何回ゆうたらわかんねん！");
            }
        }
    }
}
