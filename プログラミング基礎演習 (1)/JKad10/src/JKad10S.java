import java.util.Scanner;

public class JKad10S {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("����ɂ���!");
        System.out.println("�킽���̓X�[�p�[�e�B�[�`���[�AECC�G�N�Z�����g��!");
        System.out.print("���Ȃ��̃R�[�X�������Ă�!�@(1:IE�A2:SK�A3:SE)>");
        int a = sc.nextInt();
        if (a != 1 && a !=2 && a !=3) {
            System.out.println("�����Ɠ����Ă�!");
        }
        if (a == 1) {
            System.out.print("���܉��N��?");
            int b = sc.nextInt();
            if (b >= 1 && b <= 4) {
                System.out.println("IT�J���b�W�̊w������A��낵����!");
            } else {
                System.out.println("IE��4�N���R�[�X��!");
            }
        }
        if (a == 2) {
            System.out.print("���܉��N��?");
            int b = sc.nextInt();
            if (b >= 1 && b <= 3) {
                System.out.println("IT�J���b�W�̊w������A��낵����!");
            } else {
                System.out.println("SK��3�N���R�[�X��!");
            }
        }
        if (a == 3) {
            System.out.print("���܉��N��?");
            int b = sc.nextInt();
            if (b >= 1 && b <= 2) {
                System.out.println("IT�J���b�W�̊w������A��낵����!");
            } else {
                System.out.println("SE��2�N���R�[�X��!");
            }
        }
    }
}