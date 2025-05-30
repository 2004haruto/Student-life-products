public class JKad27D {
    public static void main(String[] args) {
        int [] a = new int [20];
        initArray(a);
        showArray(a);
    }
    public static void initArray(int[] array){
        for ( int b = 0;b< array.length;b++) {
            array[b] = (int) (Math.random() * 100);
        }
    }
    public static void showArray(int[] array) {
        for (int b = 0; b < array.length; b++) {
            System.out.print(array[b] + "\t");
        }
    }
}
