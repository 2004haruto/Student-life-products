import java.util.Scanner;

public class JKad15B1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("1 より大きい整数を入力してください＞");
        int a = in.nextInt();
        System.out.println("1から"+ a + "まで加算します !");
        int d= integrate(a);
        System.out.println("合計は" + d +"です!!");
    }
    public static int integrate(int a) {
        int b = 0;
        int c  = 0;
        while ( a<=1 ) ;
        while (b<a) {
            b++;
            c += b;

        }
        return c;
    }
}
