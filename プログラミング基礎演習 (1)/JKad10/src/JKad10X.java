import java.util.Scanner;

public class JKad10X {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int random = (int) (Math.random() * 3);
        System.out.println("����񂯂�����܂��I");
        System.out.print("���̎���o���܂����H�i0�F�O�[�A1�F�`���L�A2�F�p�[�j��");
        int a = in.nextInt();
        if ( a==0 ) {
            System.out.println("���Ȃ��̓O�[���o�����I");
        }else if ( a==1 ){
            System.out.println("���Ȃ��̓`���L���o�����I");
        }else if ( a==2 ){
            System.out.println("���Ȃ��̓p�[���o�����I");
        }
        if ( random==0 ){
            System.out.println("�R���s���[�^�̓O�[���o�����I");
        }else if ( random==1 ){
            System.out.println("�R���s���[�^�̓`���L���o�����I");
        } else if ( random==2 ){
            System.out.println("�R���s���[�^�̓p�[���o�����I");
        }
        if ( a==0 && random==0 ){
            System.out.println("��������!");
        }else if ( a==0 && random==1 ){
            System.out.println("���Ȃ��̏����I");
        }else if ( a==0 && random==2) {
            System.out.println("���Ȃ��̕����I");
        }
        if ( a==1 && random==0 ){
            System.out.println("���Ȃ��̕����I");
        }else if ( a==1 && random==1 ){
            System.out.println("��������!");
        }else if ( a==1 && random==2) {
            System.out.println("���Ȃ��̏����I");
        }
        if ( a==2 && random==0 ){
            System.out.println("���Ȃ��̏����I");
        }else if ( a==2 && random==1 ){
            System.out.println("���Ȃ��̕����I");
        }else if ( a==2 && random==2) {
            System.out.println("��������!");
        }
    }
}
