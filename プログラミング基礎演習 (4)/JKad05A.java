/*
 課題名：JKad05A
 作成日：2023/4/27
 作成者：正木陽斗
*/
import java.util.Scanner;

public class JKad05A {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("半径を入力してください＞");
		double r = in.nextDouble();
		int a = 4;
		int b = 3;
		double c = (double)a / (double)b;
		System.out.println("半径"+r+"球の表面積は"+a*3.14*r*r+"、体積は"+c*3.14*r*r*r+"です！");
	}
}