import java.util.Scanner;

public class JKad14S {
    public static void main(String[] args) {
        int random;
        Scanner in = new Scanner(System.in);
        System.out.println("������ECC �����Z���^�[�ł��I");
        System.out.println("�D�G�ȃX�^�b�t���Ή����܂��I");
        while (true) {
            random = (int) (Math.random() * 100);
            System.out.println("���ԍ��F" + random + " ���󂯕t�����I");
            System.out.print("�ǂ����܂����H�i1�F�Ή�����A����ȊO�F�����₾�j��");
            int a = in.nextInt();

            if (a == 1) {
                nobita(random);
            } else {
                System.out.println("�����ꂳ�܂ł����I");
                break;
            }
        }
    }


    public static void nobita(int random) {
        System.out.println("�̂ё��u�ڂ��ɂ܂����āI�v");
        if (random<20){
            System.out.println("�̂ё����Ή����܂����I");
            System.out.println();
        }else {
            System.out.println("�̂ё��u�E�E�E�W���C�A���A���肢�I�v");
            jaian(random);
        }
    }

    public static void jaian(int random) {
        System.out.println("�W���C�A���u�I�����܂ɂ܂�����I�v");
        if (random % 5 == 0) {
            System.out.println("�W���C�A�����Ή����܂����I");
            System.out.println();
        }else {
            System.out.println("�W���C�A���u�E�E�E�X�l�v�A���O�ɂ䂸���Ă��I�v");
            suneo(random);
        }
    }

    public static void suneo(int random) {
        System.out.println("�X�l�v�u�ڂ��̏o�Ԃ��I�v");
        if (random % 3 == 0) {
            System.out.println("�u�X�l�v���Ή����܂����I�v");
            System.out.println();
        } else {
            System.out.println("�u�E�E�E�o�ؐ��I�܂������I�v");
            dekisugi(random);
        }
    }

    public static void dekisugi(int random) {
        System.out.println("�o�ؐ��u����Ȃ̊ȒP���v");
        System.out.println("�o�ؐ����Ή����܂����I");
    }
}




