/*
 課題名：JKad04B
 作成日：2023/4/20
 作成者：正木陽斗
*/
import java.util.Scanner;

public class JKad04B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("いくつまで足し合わせますか？");
		int num = sc.nextInt();
		int res = (num + 1) * (num / 2);
		System.out.println("1から" +  num + "まで足し合わせると・・・" + res + "になりました");
		
	}
}