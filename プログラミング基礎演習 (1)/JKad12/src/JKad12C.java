import java.util.Scanner;

public class JKad12C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("1より大きい整数を入力してください>");
        int a = in.nextInt();
        int b = 1;
        int c  = 0;
        System.out.println("1から" + a + "まで加算します!");
        while ( b <= a ) {
            c+=b;
            b++;
        }
        System.out.println("合計は" + c + "です!!");
    }
}
