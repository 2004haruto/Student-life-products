import  java.util.Scanner;

public class JKad21D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] names = {"のび太", "しずか", "ジャイアン", "スネ夫", "出木杉",};
        int[] scores = new int[names.length];
        // 点数の入力
        int i = 0;
        for (;i < names.length;i++) {
            System.out.print(names[i] + "の点数（-1：欠席）＞");
            scores[i] = in.nextInt();
        }
        // 平均点の計算
        int sum = 0; // 合計
        int n = 0; // 受験した人数
        i = 0;
        for (;i < names.length;i++) {
            if (scores[i] == -1) {
                continue;
            }
            sum += scores[i];
                n++;

        }
        System.out.println("受験したのは" + n + "人です！");
        System.out.println("平均点は" + (double) sum / n + "点です！");
        in.close();
    }
}



