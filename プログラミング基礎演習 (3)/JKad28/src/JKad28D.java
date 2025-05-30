import java.util.Random;

public class JKad28D {
    public static void main(String[] args) {
        int[] array = new int[20];
        initArray(array);
        showArray(array);
        showArray(array, 5, 10, 15); // 5 番目以上15 番目未満を表示（10 番目には「」を付ける）
    }

    public static void initArray(int[] array){
        Random random = new Random();
        // 配列の設定、配列の中身0~19番目までにランドの設定が必要
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random()*99);
            //上のやつ、もしくは下のどちらか
            array[i] = random.nextInt(100);
        }
    }

    //配列arrayの値を表示する。値と値の間にはタブ入れる。
    public static void showArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }

    public static void showArray(int[] array, int start, int pivotNum, int end){
        // start未満の表示 -
        for (int i = 0; i < start; i++) {
            System.out.print("--\t");
        }

        // start以上end未満をそのまま表示かつpivotNumの位置にをつける
        for (int i = start; i < end ; i++) {
            if (i != pivotNum) {
                System.out.print(array[i] + "\t");
            }else{System.out.print(array[i] + "*\t");
            }
        }
        // end以降の表示 -
        for (int i = end; i < array.length; i++) {
            System.out.print("--\t");
        }
    }
}