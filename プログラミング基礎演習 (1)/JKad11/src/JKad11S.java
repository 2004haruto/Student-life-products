import java.util.Scanner;

public class JKad11S {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("三角形を作ります!");
        System.out.print("辺1の長さを入力してください>");
        int a = sc.nextInt();
        System.out.print("辺2の長さを入力してください>");
        int b = sc.nextInt();
        System.out.print("辺3の長さを入力してください>");
        int c = sc.nextInt();

        if ( a >= (b + c) || b >= (a + c) || c >= (a + b)) {
            System.out.println("三角形になりません!");
        }else if ( a == b && b == c ) {
            System.out.println("正三角形になります!");
        }else if ( a == b || b == c || a == c ) {
            System.out.println("二等辺三角形になります!");
        }else {
            System.out.println("三角形になります!");
        }

    }
}
