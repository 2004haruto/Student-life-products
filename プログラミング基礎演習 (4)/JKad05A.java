/*
 �ۑ薼�FJKad05A
 �쐬���F2023/4/27
 �쐬�ҁF���ؗz�l
*/
import java.util.Scanner;

public class JKad05A {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("���a����͂��Ă���������");
		double r = in.nextDouble();
		int a = 4;
		int b = 3;
		double c = (double)a / (double)b;
		System.out.println("���a"+r+"���̕\�ʐς�"+a*3.14*r*r+"�A�̐ς�"+c*3.14*r*r*r+"�ł��I");
	}
}