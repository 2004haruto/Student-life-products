public class JKad19A {
    public static void main(String[] args) {
        int[] scores = {30, 50, 100, 70, 95};
        System.out.println("最高得点を探します！");
        int max = 0;
        int a = 0;
        while (a < scores.length) {
            if (max < scores[a]) {
                max = scores[a];
            }
            a++;
        }
            System.out.println("最高得点は" + max + "点です！");
    }
}
