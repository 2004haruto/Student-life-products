/*
 課題名：JKad02C
 作成日：2023/4/13
 作成者：正木陽斗
*/
public class JKad02C {
	public static void main(String[] args) {
	//	�@ int 型変数a を宣言し、5 で初期化する。
	System.out.println("変数aの値を表示します！");
	int a;
	a = 5;
	System.out.println(a);


	//	�B int 型変数b を宣言し、20 で初期化する。
	System.out.println("変数bの値を表示します！");
		int b;
		b = 20;
		System.out.println(b);
	//	�C 変数b の値を表示する。
	System.out.println("変数ｂにaを代入します！");
	//	�D 変数b に変数a の値を代入する。
  	System.out.println("変数aの値を表示します！");
	b = a;
	//	�E 変数a の値を表示する（�Aと同じ処理）。
	System.out.println(a);
	//	�F 変数b の値を表示する（�Cと同じ処理）
	System.out.println("変数bの値を表示します！");
	System.out.println(b);
	}
}