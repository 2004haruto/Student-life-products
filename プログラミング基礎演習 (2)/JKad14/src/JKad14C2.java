import java.util.Scanner;

public class JKad14C2 {
    public static void main(String[] args) {

        System.out.println("�W���b�N�͓����܂����I");
        System.out.println("���̓��A�V�܂œ͂����̖؂ɐ��������I");
        System.out.println("������o��΂����ƕ󕨂�����ɈႢ�Ȃ��I�I");
        climbBeanTree();
        System.out.println("�߂ł����A�߂ł����B");
    }
    public static void climbBeanTree() {
        Scanner in = new Scanner(System.in);
        System.out.println("�W���b�N�͓��̖؂�o�����I");
        System.out.print("�ǂ����܂����H�i1�F�o��A����ȊO�F������ꂽ�j��");
        int a = in.nextInt();
        if ( a ==1 ) {
            climbBeanTree();
        }
        System.out.println("�W���b�N�͓��̖؂��~�肽�I");


        }

}

