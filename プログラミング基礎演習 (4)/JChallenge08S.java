/*
 �ۑ薼�FJChallenge08S
 �쐬���F2023/5/9
 �쐬�ҁF���ؗz�l
*/
import java.util.Scanner;

public class JChallenge08S {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("���݂̎����i���j����͂��Ă��������i0-23�j��");
		int current_hour = sc.nextInt();
		System.out.print("���݂̎����i���j����͂��Ă��������i0-59�j��");
		int current_min = sc.nextInt();
		System.out.print("���ƏI���̎����i���j����͂��Ă��������i0-23�j��");
		int target_hour = sc.nextInt();
		System.out.print("���ƏI���̎����i���j����͂��Ă��������i0-59�j��");
		int target_min = sc.nextInt();
		int hour = current_hour*60+current_min;
		int min = target_hour*60+target_min;
		double answer = ( hour - min ); 
		int res =((target)-(current));
		hour = res/60;
		min = res%60;
		System.out.println("����" + (hour) + "����" + (min) + "���A����΂�I");	
		
	}
}