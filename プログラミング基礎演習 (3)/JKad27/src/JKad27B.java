public class JKad27B {
    public static void main(String[] args) {
        int[] a = new int[20];
        initArray(a);
        showArray(a);
        System.out.println();
        System.out.println("ï¿Ç◊ë÷Ç¶Ç‹Ç∑ÅI");
        bubbleSort(a);
        System.out.println();
        System.out.println("ï¿Ç◊ë÷Ç¶ÇµÇ‹ÇµÇΩÅI");
        showArray(a);
    }

    public static void initArray(int[] array) {
        for (int b = 0; b < array.length; b++) {
            array[b] = (int) (Math.random() * 100);
        }
    }

    public static void showArray(int[] array) {
        for (int b = 0; b < array.length; b++) {
            System.out.print(array[b] + "\t");
        }
        System.out.println();
    }

    public static void bubbleSort(int[] array) {
        int a = 0;
        int b;
        for (int c=0;c<array.length;c++) {
            for (a=0; a< array.length - 1;a++) {
                if (array[a] > array[a + 1]) {
                    b = array[a];
                    array[a] = array[a + 1];
                    array[a + 1] = b;
                }
                showArray(array);
            }
            System.out.println("----------------------------------------------------");
        }
    }
}




