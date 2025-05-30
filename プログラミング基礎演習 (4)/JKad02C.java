/*
 課題名：JKad02C
 作成日：2023/4/13
 作成者：正木陽斗
*/
public class JKad02C {
	public static void main(String[] args) {
	//	① int 型変数a を宣言し、5 で初期化する。
	System.out.println("変数aの値を表示します！");
	int a;
	a = 5;
	System.out.println(a);


	//	③ int 型変数b を宣言し、20 で初期化する。
	System.out.println("変数bの値を表示します！");
		int b;
		b = 20;
		System.out.println(b);
	//	④ 変数b の値を表示する。
	System.out.println("変数ｂにaを代入します！");
	//	⑤ 変数b に変数a の値を代入する。
  	System.out.println("変数aの値を表示します！");
	b = a;
	//	⑥ 変数a の値を表示する（②と同じ処理）。
	System.out.println(a);
	//	⑦ 変数b の値を表示する（④と同じ処理）
	System.out.println("変数bの値を表示します！");
	System.out.println(b);
	}
}