import java.util.Scanner;

public class JKad14B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("円の面積を求めます！");
        System.out.print("半径の長さを入力してください＞");
        int a = in.nextInt();
        System.out.print("誰に計算させますか？（1：のび太、2：出木杉）＞");
        int b = in.nextInt();
        if ( b ==1 ) {
            nobita(a);
        }else if (b ==2) {
            dekisugi(a);
        }
    }
    public static void nobita(int a) {
        System.out.println("半径"+a+"の円の面積は"+a*a*3+"だよ!");
    }
    public static void dekisugi(int a) {
        System.out.println("半径"+a+"の円の面積は"+a*a*3.14+"さ!");
    }
}
