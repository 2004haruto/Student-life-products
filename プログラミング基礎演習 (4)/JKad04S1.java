import java.util.Scanner;

public class JKad04S1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("0 ����255 �܂ł̐�������͂��Ă���������");
		int num = sc.nextInt();
		System.out.println("�ŉ��ʃr�b�g���珇�ɕ\�����܂��I");
		System.out.println(num % 2);
		System.out.println(num/2 % 2);
		System.out.println(num/4 % 2);
		System.out.println(num/8 % 2);
		System.out.println(num/16 % 2);
		System.out.println(num/32 % 2);
		System.out.println(num/64 % 2);
		System.out.println(num/128 % 2);
	}
}