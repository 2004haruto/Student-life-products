/*
	�ۑ薼�FJ2Kad05S�uECC�R�[�q�[�I�v
	�쐬���F2023/10/10
	�쐬�ҁF�c�����Y
*/
import java.util.Scanner;

public class J2Kad05S {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("ECC�R�[�q�[�ւ悤�����I");
        System.out.println("��O�s�o�̃��V�s�ō�邩��A����������I�I");
        System.out.println();

        while (true) {
            System.out.print("�������́H�i0�F�R�[�q�[�A1�G�g���A2�F�R�R�A�A3�F�~���N�e�B�[�A-1�F�X���o��j��");
            int	n = in.nextInt();
            if (n < 0) break;

            switch (n) {
                default:
                case 0:
                    // �R�[�q�[�����
                    Coffee coffee = new Coffee();
                    coffee.boilWater();
                    coffee.dripCoffee();
                    coffee.pourInCup();
                    break;
                case 1:
                    // �g�������
                    Tea tea = new Tea();
                    tea.boilWater();
                    tea.steepTeabag();
                    tea.pourInCup();
                    break;
                case 2:
                    // �R�R�A�����



                    break;
                case 3:
                    // �g�������



                    break;
            }
            System.out.println("���҂������܂����I���������ǂ����I");
            System.out.println();
        }
        System.out.println("���肪�Ƃ��������܂����I");
    }
}
