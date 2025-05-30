import java.util.Scanner;

public class JKad15D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("1 より大きい整数1 を入力してください＞");
        int a = in.nextInt();
        System.out.print("1 より大きい整数2 を入力してください＞");
        int b = in.nextInt();
        System.out.println(a+"÷"+b+"の商と余りを計算します！");
        System.out.println("出木杉くん、よろしく！");
        dekisugi(a,b) ;
    }
    public static void dekisugi(int a, int b){
        System.out.println("そんなの簡単さ！");
        System.out.println("商は"+a/b+"、余りは"+a%b+"だよ。");
    }
}
