public class JKad19A {
    public static void main(String[] args) {
        int[] scores = {30, 50, 100, 70, 95};
        System.out.println("�ō����_��T���܂��I");
        int max = 0;
        int a = 0;
        while (a < scores.length) {
            if (max < scores[a]) {
                max = scores[a];
            }
            a++;
        }
            System.out.println("�ō����_��" + max + "�_�ł��I");
    }
}
