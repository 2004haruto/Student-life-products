import java.util.Scanner;

public class JKad15X {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("�`���R�������Ă����܂��I");
        System.out.print("�c�̃u���b�N�͂����ł����H��");
        int Rows = in.nextInt();
        System.out.print("���̃u���b�N�͂����ł����H��");
        int Colums = in.nextInt();

        if(Rows < 1){
            System.out.print("���͒l���͈͊O�Ȃ̂ŏI��");
            return;
        }
        if(Colums < 1){
            System.out.print("���͒l���͈͊O�Ȃ̂ŏI��");
            return;
        }

        System.out.print("�N������񐔂��v�Z���܂����H�i1�F�o�ؐ��A����ȊO�F�������j��");
        int who = in.nextInt();

        if(who < 1){
            System.out.print("���͒l���͈͊O�Ȃ̂ŏI��");
            return;
        }

        if(who == 1){
            dekisugi(Rows, Colums);
        }else {
            sizuka(Rows, Colums);
        }
    }
    public static void dekisugi(int v, int h){
        System.out.print("����͂Ȃ��Ȃ��育�킢���I\n" + "�Ƃ肠����1 �񊄂��āA���ꂼ����܂������āA�S����" + breakOff(v, h) + " ��");
    }
    public static void sizuka(int v, int h){
        System.out.print("����Ȃ̊ȒP��I\n" +
                "1 �񊄂�Δj�Ђ��������B�S����n���Ђ���ꍇ�A���R�Ō�̈ꌇ�ɂȂ�Ɗ���Ȃ�(��菜���Ȃ�)�̂�n-1�񊄂��B\n" +
                "�S����" + v * h + " �ɂ���ɂ�" + (v*h - 1) + " �񊄂�΂����̂�B\n");
    }

    public static int breakOff(int v, int h){
        if(v > 1) return 1 + breakOff(v / 2, h) + breakOff(v - v / 2, h);

        if(h > 1) return 1 + breakOff(v, h / 2) + breakOff(v, h - h /2);

        return 0;
    }
}
