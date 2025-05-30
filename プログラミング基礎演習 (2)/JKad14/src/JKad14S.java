import java.util.Scanner;

public class JKad14S {
    public static void main(String[] args) {
        int random;
        Scanner in = new Scanner(System.in);
        System.out.println("ここはECC 苦情処理センターです！");
        System.out.println("優秀なスタッフが対応します！");
        while (true) {
            random = (int) (Math.random() * 100);
            System.out.println("苦情番号：" + random + " を受け付けた！");
            System.out.print("どうしますか？（1：対応する、それ以外：もうやだ）＞");
            int a = in.nextInt();

            if (a == 1) {
                nobita(random);
            } else {
                System.out.println("おつかれさまでした！");
                break;
            }
        }
    }


    public static void nobita(int random) {
        System.out.println("のび太「ぼくにまかせて！」");
        if (random<20){
            System.out.println("のび太が対応しました！");
            System.out.println();
        }else {
            System.out.println("のび太「・・・ジャイアン、お願い！」");
            jaian(random);
        }
    }

    public static void jaian(int random) {
        System.out.println("ジャイアン「オレさまにまかせろ！」");
        if (random % 5 == 0) {
            System.out.println("ジャイアンが対応しました！");
            System.out.println();
        }else {
            System.out.println("ジャイアン「・・・スネ夫、お前にゆずってやる！」");
            suneo(random);
        }
    }

    public static void suneo(int random) {
        System.out.println("スネ夫「ぼくの出番だ！」");
        if (random % 3 == 0) {
            System.out.println("「スネ夫が対応しました！」");
            System.out.println();
        } else {
            System.out.println("「・・・出木杉！まかせた！」");
            dekisugi(random);
        }
    }

    public static void dekisugi(int random) {
        System.out.println("出木杉「こんなの簡単さ」");
        System.out.println("出木杉が対応しました！");
    }
}




