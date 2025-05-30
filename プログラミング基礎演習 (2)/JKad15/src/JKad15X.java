import java.util.Scanner;

public class JKad15X {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("板チョコを割っていきます！");
        System.out.print("縦のブロックはいくつですか？＞");
        int Rows = in.nextInt();
        System.out.print("横のブロックはいくつですか？＞");
        int Colums = in.nextInt();

        if(Rows < 1){
            System.out.print("入力値が範囲外なので終了");
            return;
        }
        if(Colums < 1){
            System.out.print("入力値が範囲外なので終了");
            return;
        }

        System.out.print("誰が割る回数を計算しますか？（1：出木杉、それ以外：しずか）＞");
        int who = in.nextInt();

        if(who < 1){
            System.out.print("入力値が範囲外なので終了");
            return;
        }

        if(who == 1){
            dekisugi(Rows, Colums);
        }else {
            sizuka(Rows, Colums);
        }
    }
    public static void dekisugi(int v, int h){
        System.out.print("これはなかなか手ごわいぞ！\n" + "とりあえず1 回割って、それぞれをまた割って、全部で" + breakOff(v, h) + " 回だ");
    }
    public static void sizuka(int v, int h){
        System.out.print("そんなの簡単よ！\n" +
                "1 回割れば破片が一つ増える。全部でn欠片ある場合、当然最後の一欠になると割れない(取り除けない)のでn-1回割れる。\n" +
                "全部で" + v * h + " 個にするには" + (v*h - 1) + " 回割ればいいのよ。\n");
    }

    public static int breakOff(int v, int h){
        if(v > 1) return 1 + breakOff(v / 2, h) + breakOff(v - v / 2, h);

        if(h > 1) return 1 + breakOff(v, h / 2) + breakOff(v, h - h /2);

        return 0;
    }
}
