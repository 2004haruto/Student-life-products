import java.util.Scanner;

public class JKad15B2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("1 より大きい整数を入力してください＞");
        int a = in.nextInt();
        System.out.println("1から"+ a + "まで加算します !");
        int b= integrate(a);
        System.out.println("合計は" + b +"です!!");
    }
    public static int integrate(int a) {
        int c;
        if (a == 1) {
            return 1;
        } else {
            c = integrate( a- 1);

        }

        return a + c;
    }
}
