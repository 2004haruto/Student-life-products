import java.util.Scanner;

public class JKadC2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("1 より大きい整数を入力してください＞");
        int a = in.nextInt();
        System.out.println("1から" + a + "まで加算します!");
        int b;
        int c = 0;
        for (b = 1; b <= a; b++) {
            c+=b;
        }
        System.out.println("合計は" + c + "です!");
    }
}
