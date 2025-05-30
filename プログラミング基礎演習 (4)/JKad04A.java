/*
 ‰Û‘è–¼FJKad04A
 ì¬“úF2023/4/20
 ì¬ÒF³–Ø—z“l
*/
import java.util.Scanner;

public class JKad04A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("‹³º”Ô†‚ğ“ü—Í‚µ‚Ä‚­‚¾‚³‚¢>");
		int num = sc.nextInt();
		System.out.println("ˆê‚ÌˆÊ" + (num % 10));
		System.out.println("\‚ÌˆÊ" + (num/10 % 10));
		System.out.println("•S‚ÌˆÊ" + (num/100 % 10));
		System.out.println("ç‚ÌˆÊ" + (num/1000 % 10));	
	}
}