/*
	�ۑ薼�FJ2Kad14C�u��O�����A�itry�`catch�`finally�j�v
	�쐬���F2023/11/14
	�쐬�ҁF�c�����Y
*/
import java.util.InputMismatchException;
import java.util.Scanner;

public class J2Kad14C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        try {
            System.out.print("����1����͂��Ă���������");
            int n1 = in.nextInt();
            System.out.print("����2����͂��Ă���������");
            int n2 = in.nextInt();
            div(n1, n2);
        }catch (InputMismatchException ime){
            System.out.println(ime);
            System.out.println("�����琮������͂������Ă䂤�Ă���I");
        }catch (ArithmeticException ae){
            System.out.println(ae);
            System.out.println("�[���Ŋ�������ǂȂ��Ȃ�v���Ă�˂�I");
        }finally {
            System.out.println("finally �u���b�N�̏����ł��I");
        }
    }
    public static void div(int n1, int n2) {
        System.out.println(n1 + "��" + n2 +"���v�Z���܂��I");
        int ans = n1 / n2;
        System.out.println("�v�Z���ʂ�" + ans + "�ł��I");
    }
}
