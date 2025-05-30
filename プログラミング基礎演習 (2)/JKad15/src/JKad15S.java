import java.util.Scanner;

public class JKad15S {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("トーナメントのチーム数を入力してください＞");
        int a = in.nextInt();
        System.out.print("誰が試合数を計算しますか？（1：出木杉、それ以外：しずか）＞");
        int n = in.nextInt();
        if (n == 1) {
            dekisugi(a);
            System.out.println("トータルの試合数は"+(a-1)+"だよ");
        } else {
            sizuka(a);
        }
    }

    public static void dekisugi(int a) {
        System.out.println("そんなの簡単さ！");
        int b = 1;
        while (a > 1) {
            int c = a / 2;
            int d = a % 2;
            int e = c + d;
            System.out.println(b + "回戦の試合数：" + c + " 不戦勝：" + d + " 残りチーム：" + e);
            a = e;
            b++;
        }

    }

    public static void sizuka(int a) {
        System.out.println("そんなの簡単よ！");
        System.out.println("1引けば答えになる");
        int ab = a - 1;
        System.out.println("最後に1チーム残るためには" + ab + "試合すればいいのよ!");
    }
}
