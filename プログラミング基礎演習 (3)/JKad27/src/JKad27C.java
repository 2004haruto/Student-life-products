public class JKad27C {
    public static void main(String[] args) {
        int[] a = new int[20];
        initArray(a);
        showArray(a);
        System.out.println();
        System.out.println("並べ替えます！");
        bubbleSort(a);
        System.out.println();
        System.out.println("並べ替えしました！");
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
        while (a < array.length - 1) {
            if (array[a] > array[a + 1]) {
                b = array[a];
                array[a] = array[a + 1];
                array[a + 1] = b;
            }
            a++;
            showArray(array);
        }
    }
}



