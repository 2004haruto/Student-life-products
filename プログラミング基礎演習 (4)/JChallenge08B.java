
/*
 �ۑ薼�FJChallenge08B
 �쐬���F2023/5/9
 �쐬�ҁF���ؗz�l
*/
import java.util.Scanner;

public class JChallenge08B {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("A ����̑O���Ԃ��ʉ߂��܂��I");
	System.out.print("��Ԃ̑��x�ikm/���j����͂��Ă���������");
	int speed = sc.nextInt();	
	System.out.print("��Ԃ̒����i���[�g���j����͂��Ă���������");
	int length = sc.nextInt();
	double result = length/(speed*1000/3600.0);
	System.out.println(result + "�b������܂�!");	
	}
}