import java.util.Scanner;

public class JKad09D2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("����ɂ��́I");
        System.out.println("�킽���̓X�[�p�[�e�B�[�`���[�AECC�G�N�Z�����g��I");
        System.out.print("���Ȃ��̃N���X�������ĂˁI�i1:IE�A2:SK�A3:SE)>");
        int a = sc.nextInt();
        if ( a == 1 ) {
            System.out.println("4�N���R�[�X�Ȃ̂ˁI");
        }
        if ( a == 2 ) {
            System.out.println("3�N���R�[�X�Ȃ̂ˁI");
        }
        if ( a == 3 ) {
            System.out.println("2�N���R�[�X�Ȃ̂ˁI");
        }
    }
}
