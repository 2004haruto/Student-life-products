
/*
 課題名：JChallenge08B
 作成日：2023/5/9
 作成者：正木陽斗
*/
import java.util.Scanner;

public class JChallenge08B {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("A さんの前を列車が通過します！");
	System.out.print("列車の速度（km/時）を入力してください＞");
	int speed = sc.nextInt();	
	System.out.print("列車の長さ（メートル）を入力してください＞");
	int length = sc.nextInt();
	double result = length/(speed*1000/3600.0);
	System.out.println(result + "秒かかります!");	
	}
}