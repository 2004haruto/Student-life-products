/*
 課題名：JKad04A
 作成日：2023/4/20
 作成者：正木陽斗
*/
import java.util.Scanner;

public class JKad04A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("教室番号を入力してください>");
		int num = sc.nextInt();
		System.out.println("一の位" + (num % 10));
		System.out.println("十の位" + (num/10 % 10));
		System.out.println("百の位" + (num/100 % 10));
		System.out.println("千の位" + (num/1000 % 10));	
	}
}