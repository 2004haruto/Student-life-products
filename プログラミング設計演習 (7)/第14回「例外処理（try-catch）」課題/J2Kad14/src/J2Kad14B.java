/*
	�ۑ薼�FJ2Kad14B�uECC�����A���|��3�����I�v
	�쐬���F2023/11/14
	�쐬�ҁF�c�����Y
*/
import java.util.InputMismatchException;
import java.util.Scanner;

public class J2Kad14B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Sheep[] nagaya = new Sheep[] { new Sheep(), new Sheep(), new Sheep() };
        String n= "0"; //�O���Ő錾
        while(true) {
            try {
                System.out.print("�����������܂����H�i-1�F�����Ȃ��j��");
                //���b�p�[�N���X
                //��{�f�[�^�^���I�u�W�F�N�g�ɂ������
                n = in.next();//���͂𕶎���Ŏ󂯎��
                //������𐔎��ɕϊ�
                int num = Integer.parseInt(n);
                if (num < 0) break;
                nagaya[num].intro();
                System.out.println();
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("�z��̕�������3 �₯�ǁA�����ԍ���0 ����n�܂邩��A0 �����E1 �����E2 �����܂ł����Ȃ��˂�B"+n+" �����͂Ȃ����ĉ���䂤����킩��˂�H");
            }catch (NumberFormatException nfe){
                //InputMismatchException �� NumberFormatException �ɕύX
                System.out.println("�����ԍ��͐�������ĉ���䂤����킩��˂�I");
            }
        }
    }
}
