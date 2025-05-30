import  java.util.Scanner;

public class JKad09S {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("のびたの点数を入力してください＞");
        int a = in.nextInt();
        System.out.print("しずかの点数を入力してください＞");
        int b = in.nextInt();
        System.out.print("ジャイアンの点数を入力してください＞");
        int c = in.nextInt();
        System.out.print("スネ夫の点数を入力してください＞");
        int d = in.nextInt();
        System.out.print("出木杉の点数を入力してください＞");
        int e = in.nextInt();

        int f =0;

        if (a < b){
            f = a;
            a = b;
        }else{
            if (f < b){
                f = b;
            }
        }
        if (a < c){
            f = a;
            a = c;
        }else{
            if (f < c){
                f = c;
            }
        }
        if (a < d){
            f = a;
            a = d;
        }else{
            if (f < d){
                f = d;
            }
        }
        if (a < e) {
            f = a;
            a = e;
        }else{
            if (f < e){
                f = e;
            }
        }
        System.out.println("二番目に高いのは"+f+"です");
    }
}
