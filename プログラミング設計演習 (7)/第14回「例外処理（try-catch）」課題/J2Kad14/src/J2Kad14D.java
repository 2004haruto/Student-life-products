/*
	課題名：J2Kad14D「例外処理①（try～catch）」
	作成日：2023/11/14
	作成者：田中太郎
*/
import java.util.InputMismatchException;
import java.util.Scanner;

public class J2Kad14D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //例外処理　try-catch
        try {
            System.out.print("あなたの年齢を教えてください＞");
            int age = in.nextInt();
            System.out.println("あなたは" + age + "歳なんですね！");
        } catch (InputMismatchException ime){
            System.out.println(ime);
            System.out.println("何で整数ちゃうねん！年齢は整数に決まっとるやろ！！");
            //ime.printStackTrace(); 例外のいつもの処理
        }
    }
}
