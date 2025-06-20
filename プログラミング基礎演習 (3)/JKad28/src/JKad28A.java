public class JKad28A {
    public static void main(String[] args) {
        int[] array = new int[20];
        JKad28D.initArray(array);
        JKad28D.showArray(array);
        selectionSort(array); // すべてのデータを昇順に並べ替える
        JKad28D.showArray(array);
    }

    public static void selectionSort(int[] array, int start){
        JKad28C.selectionSort(array, start);
        start++;
        if (start != array.length) selectionSort(array, start);
    }

    public static void selectionSort(int[] array){
        selectionSort(array,0);
    }
}