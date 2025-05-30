public class JKad28C {
    public static void main(String[] args) {
        int[] array = new int[20];
        JKad28D.initArray(array);
        JKad28D.showArray(array);
        selectionSort(array, 0); // 選択ソート（0 番目から最後尾まで）
        selectionSort(array, 1); // 選択ソート（1 番目から最後尾まで）
        selectionSort(array, 2); // 選択ソート（2 番目から最後尾まで）
        JKad28D.showArray(array);
    }
    public static void selectionSort(int[] array, int start) {
        int min = start; // 一番小さい値のインデックス
        int minValue = array[start]; //一番小さい値を保持する

        //一番小さい値を探す
        for (int i = start+1; i < array.length; i++) {
            // 値が小さかったら位置を変更する
            if (array[i] < minValue){
                min = i;
                minValue = array[i];
            }
        }

        JKad28D.showArray(array, start, min, array.length); // start 番目から最後尾まで表示
        System.out.println();

        //start 番目とmin 番目の入れ替え
        int num = array[start];
        array[start] = array[min];
        array[min] = num;
    }
}