import java.util.Scanner;

public class JKad09B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("ひとつめの整数を入力してください＞");
        int a = sc.nextInt();
        System.out.print("ふたつめの整数を入力してください＞");
        int b = sc.nextInt();
        System.out.print("誰が計算しますか？(1:のび太、1以外:出木杉>");
        int c = sc.nextInt();
        double d = (double)a/(double)b;
        if ( c==1 ) {
            System.out.println("のび太が計算します！");
            System.out.println("「" + (a) + "÷" + (b) + "は" + (a / b) + "です！」");

        } else {
            System.out.println("出木杉が計算します！");
            System.out.println("「" + (a) + "÷" + (b) + "は" +d+ "です！」");
        }
    }
}
