/*
	課題名：J2Kad14C「例外処理②（try～catch～finally）」
	作成日：2023/11/14
	作成者：田中太郎
*/
import java.util.InputMismatchException;
import java.util.Scanner;

public class J2Kad14C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        try {
            System.out.print("整数1を入力してください＞");
            int n1 = in.nextInt();
            System.out.print("整数2を入力してください＞");
            int n2 = in.nextInt();
            div(n1, n2);
        }catch (InputMismatchException ime){
            System.out.println(ime);
            System.out.println("だから整数を入力せえってゆうてるやろ！");
        }catch (ArithmeticException ae){
            System.out.println(ae);
            System.out.println("ゼロで割ったらどないなる思ってんねん！");
        }finally {
            System.out.println("finally ブロックの処理です！");
        }
    }
    public static void div(int n1, int n2) {
        System.out.println(n1 + "÷" + n2 +"を計算します！");
        int ans = n1 / n2;
        System.out.println("計算結果は" + ans + "です！");
    }
}
