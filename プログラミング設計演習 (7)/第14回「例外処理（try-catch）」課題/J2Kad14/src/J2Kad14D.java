/*
	�ۑ薼�FJ2Kad14D�u��O�����@�itry�`catch�j�v
	�쐬���F2023/11/14
	�쐬�ҁF�c�����Y
*/
import java.util.InputMismatchException;
import java.util.Scanner;

public class J2Kad14D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //��O�����@try-catch
        try {
            System.out.print("���Ȃ��̔N��������Ă���������");
            int age = in.nextInt();
            System.out.println("���Ȃ���" + age + "�΂Ȃ�ł��ˁI");
        } catch (InputMismatchException ime){
            System.out.println(ime);
            System.out.println("���Ő������Ⴄ�˂�I�N��͐����Ɍ��܂��Ƃ���I�I");
            //ime.printStackTrace(); ��O�̂����̏���
        }
    }
}
