/*
 課題名：JKad04C
 作成日：2023/4/20
 作成者：正木陽斗
*/
import java.util.Scanner;

public class JKad04C {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("あなたのお名前は？>");
		String name =  sc.next();
		System.out.println("こんにちは。" + name + "さん!");
		System.out.println("年齢はいくつ？>");
		int age = sc.nextInt();
		System.out.println(age + "歳なのね！");
		sc.close();
	}
}