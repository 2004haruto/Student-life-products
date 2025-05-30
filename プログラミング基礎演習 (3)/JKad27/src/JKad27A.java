public class JKad27A {
    public static void main(String[] args) {
        int[] array = new int [20];
        JKad27D.initArray(array);
        JKad27D.showArray(array);
        System.out.println("並び替えます");
        mergeSort(array);
        System.out.println("並び替えました");
        JKad27D.showArray(array);
    }
    public static void mergeSort(int[] array) {
        int mid = array.length/2;
        int[] array1 = new int [mid];
        int[] array2 = new int [array.length - mid];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = array[i];
        }
        for (int i = 0; i < array2.length; i++) {
            array2[i] = array[mid + i];
        }
        System.out.println("前半を並び替えます！");
        JKad27B.bubbleSort(array1);
        System.out.println("後半を並び替えます！");
        JKad27B.bubbleSort(array2);

        System.out.println("マージします");
        for (int i = 0; i < array1.length;i++){
            array[i] = array1[i];
        }
        for (int i = 0; i < array2.length;i++){
            array[mid + i] = array2[i];
        }
    }
}