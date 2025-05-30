import java.util.Scanner;

public class JKad15C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("1 より大きい整数1 を入力してください＞");
        int a = in.nextInt();
        System.out.print("1 より大きい整数2 を入力してください＞");
        int b = in.nextInt();
        System.out.println(a+"÷"+b+"の商と余りを計算します！");
        System.out.print("誰を呼び出しますか？（1：出木杉、それ以外：のび太）＞");
        int c = in.nextInt();
        if ( c==1 ){
            dekisugi(a,b) ;
        }else{
            nobita(a,b);
        }

    }
    public static void dekisugi(int a, int b){
        System.out.println("そんなの簡単さ！");
        System.out.println("商は"+a/b+"、余りは"+a%b+"だよ。");
    }
    public static void nobita(int a, int b){
        System.out.println("あ、そうか！リンゴを食べる問題と一緒だね！");
        int d = 0;
        while(a >= b) {
            a -= b;
        }
            System.out.println("商は"+b+"、余りは"+a+"だよ。");

    }
}
