/*
 �ۑ薼�FJKad04A
 �쐬���F2023/4/20
 �쐬�ҁF���ؗz�l
*/
import java.util.Scanner;

public class JKad04A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("�����ԍ�����͂��Ă�������>");
		int num = sc.nextInt();
		System.out.println("��̈�" + (num % 10));
		System.out.println("�\�̈�" + (num/10 % 10));
		System.out.println("�S�̈�" + (num/100 % 10));
		System.out.println("��̈�" + (num/1000 % 10));	
	}
}