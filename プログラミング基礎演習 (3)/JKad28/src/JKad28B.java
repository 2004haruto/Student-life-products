public class JKad28B {
    public static void main(String[] args) {
        int[] array = new int[20];
        JKad28D.initArray(array);
        JKad28D.showArray(array);
        selectionSort(array); // すべてのデータを昇順に並べ替える
        JKad28D.showArray(array);
    }
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length-1 ; i++) {
            JKad28C.selectionSort(array,i);
        }
    }

}