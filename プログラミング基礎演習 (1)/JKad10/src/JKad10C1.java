import java.util.Scanner;

public class JKad10C1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("����ɂ���!");
        System.out.println("�킽���̓X�[�p�[�e�B�[�`���[�AECC�G�N�Z�����g��!");
        System.out.print("���Ȃ��̃R�[�X�������Ă�!�@(1:IE�A2:SK�A3:SE)>");
        int a = sc.nextInt();
        if (1 <=a && a<=3) {
            System.out.println("IT�J���b�W�̊w����!");
        }else{
            System.out.println("�����Ɠ����Ă�!");
        }

    }
}
