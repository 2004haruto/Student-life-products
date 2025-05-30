import java.util.Scanner;

public class JKad09A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("のび太の点数を入力してください>");
        int a = sc.nextInt();
        System.out.print("しずかちゃんの点数を入力してください>");
        int b = sc.nextInt();
        System.out.print("ジャイアンの点数を入力してください>");
        int c = sc.nextInt();
        System.out.print("スネ夫の点数を入力してください>");
        int d = sc.nextInt();
        System.out.print("出木杉くんの点数を入力してください>");
        int e = sc.nextInt();

        int max = a;
        if (max<a) {
            max = a;
        }
        if (max<b) {
            max = b;
        }
        if (max<c) {
            max = c;
        }
        if (max<d) {
            max = d;
        }
        if (max<e) {
            max = e;
        }
        System.out.println("一番高い点数は"+ max + "です！");
        }

    }

