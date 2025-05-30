/*
	課題名：J2Kad18A「ECC野球部！」
	作成日：2023/11/30
	作成者：田中太郎
*/
import java.io.BufferedReader;
import java.util.Scanner;

public class J2Kad18A {
    enum BALL {STRAIGHT, CURVE, FORKBALL}
    public static void main(String[] args) {
        System.out.println("あなたはECC野球部の名キャッチャーです！");
        System.out.println("サインを出してピッチャーの球をキャッチしてください！");

        Scanner in = new Scanner(System.in);
        BALL[] balls = BALL.values();//enumの値を配列に入れる

        while(true) {
            try {
            System.out.print("何のサインを出しますか？（0：直球、1：カーブ、2：フォーク、-1：終了）＞");
            int n = Integer.parseInt(in.next());
            //引数にnだけでは無理。ボール型を渡す必要がある
            throwBall(balls[n]);
        }catch (Ball e) {
                System.out.println(e);
                System.out.println("キャッチしました！");
        }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("そんな球種はありません！");
        }
        System.out.println();
        }
    }

    //Ballでまとめておくと楽
    public static void throwBall(BALL ball) throws Ball{
        switch (ball){
            case STRAIGHT : throw new Straight();
            case CURVE: throw new Curve();
            case FORKBALL: throw new ForkBall();
        }
    }
}
//ストレート、カーブ、フォークの親クラス(例外)を作る
class Ball extends Exception{
    public Ball(String msg){
        super(msg);
    }
}
//ストレートの例外
class Straight extends Ball {
    public Straight(){
        super("ストレートを投げた！");
    }
}
//カーブの例外
class Curve extends Ball{
    public Curve(){
        super("カーブを投げた！");
    }
}
//フォークの例外
class ForkBall extends Ball{
    public ForkBall(){
        super("フォークボールを投げた！");
    }
}