import java.util.Random;

public class JKad28D {
    public static void main(String[] args) {
        int[] array = new int[20];
        initArray(array);
        showArray(array);
        showArray(array, 5, 10, 15); // 5 �Ԗڈȏ�15 �Ԗږ�����\���i10 �Ԗڂɂ́u�v��t����j
    }

    public static void initArray(int[] array){
        Random random = new Random();
        // �z��̐ݒ�A�z��̒��g0~19�Ԗڂ܂łɃ����h�̐ݒ肪�K�v
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random()*99);
            //��̂�A�������͉��̂ǂ��炩
            array[i] = random.nextInt(100);
        }
    }

    //�z��array�̒l��\������B�l�ƒl�̊Ԃɂ̓^�u�����B
    public static void showArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }

    public static void showArray(int[] array, int start, int pivotNum, int end){
        // start�����̕\�� -
        for (int i = 0; i < start; i++) {
            System.out.print("--\t");
        }

        // start�ȏ�end���������̂܂ܕ\������pivotNum�̈ʒu�ɂ�����
        for (int i = start; i < end ; i++) {
            if (i != pivotNum) {
                System.out.print(array[i] + "\t");
            }else{System.out.print(array[i] + "*\t");
            }
        }
        // end�ȍ~�̕\�� -
        for (int i = end; i < array.length; i++) {
            System.out.print("--\t");
        }
    }
}