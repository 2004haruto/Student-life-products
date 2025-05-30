/*
 課題名：JChallenge08S
 作成日：2023/5/9
 作成者：正木陽斗
*/
import java.util.Scanner;

public class JChallenge08S {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("現在の時刻（時）を入力してください（0-23）＞");
		int current_hour = sc.nextInt();
		System.out.print("現在の時刻（分）を入力してください（0-59）＞");
		int current_min = sc.nextInt();
		System.out.print("授業終了の時刻（時）を入力してください（0-23）＞");
		int target_hour = sc.nextInt();
		System.out.print("授業終了の時刻（分）を入力してください（0-59）＞");
		int target_min = sc.nextInt();
		int hour = current_hour*60+current_min;
		int min = target_hour*60+target_min;
		double answer = ( hour - min ); 
		int res =((target)-(current));
		hour = res/60;
		min = res%60;
		System.out.println("あと" + (hour) + "時間" + (min) + "分、がんばれ！");	
		
	}
}