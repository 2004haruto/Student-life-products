

import java.util.Scanner;

public class JKad14A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("直角二等辺三角形の面積を求めます！");
        System.out.print("斜辺の長さを入力してください＞");
        int a = in.nextInt();
        System.out.print("誰に計算させますか？（1：出木杉、2：しずか）＞");
        int b = in.nextInt();
        if ( b ==1 ) {
            dekisugi(a);
        }else if (b==2) {
            sizuka(a);
        }
    }
    public static void dekisugi(int a){
        double x = a/1.41421356;
        System.out.println("三角形の面積は底辺×高さ÷2 だから、底辺と高さを求めればいいんだ！");
        System.out.println("底辺が"+x+"、高さも同じだから");
        System.out.println("直角二等辺三角形の面積は"+ x*x/2+"だよ!");
    }
    public static void sizuka(int a){
        double y = a*a;
        System.out.println("直角二等辺三角形が4 つで正方形になるから、正方形の面積を求めて4 で割ればいいんだわ！");
        System.out.println("正方形の面積は"+a*a+"だから");
        System.out.println("直角二等辺三角形の面積は"+y/4+"ね!");
    }
}
