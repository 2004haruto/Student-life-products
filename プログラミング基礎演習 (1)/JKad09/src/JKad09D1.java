import java.util.Scanner;

public class JKad09D1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("ひとつめの整数を入力してください＞");
        int a = sc.nextInt();
        System.out.print("ふたつめの整数を入力してください＞");
        int b = sc.nextInt();
        if (a < b) {
            System.out.println("ふたつの数字で大きいほうは" + b + "です！");
        } else {

            System.out.println("ふたつの数字で大きいほうは" + a + "です！");

        }
    }
}
