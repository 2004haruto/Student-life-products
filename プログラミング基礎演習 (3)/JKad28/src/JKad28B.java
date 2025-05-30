public class JKad28B {
    public static void main(String[] args) {
        int[] array = new int[20];
        JKad28D.initArray(array);
        JKad28D.showArray(array);
        selectionSort(array); // ‚·‚×‚Ä‚Ìƒf[ƒ^‚ğ¸‡‚É•À‚×‘Ö‚¦‚é
        JKad28D.showArray(array);
    }
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length-1 ; i++) {
            JKad28C.selectionSort(array,i);
        }
    }

}