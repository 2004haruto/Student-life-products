import java.util.Scanner;

public class JKad11D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("ひとつめの整数を入力してください>");
        int a = sc.nextInt();
        System.out.print("ふたつめの整数を入力してください>");
        int b = sc.nextInt();
        System.out.print("1+2の答えを入力してください>");
        int c = sc.nextInt();
        boolean correct = ( a + b ) == c;
        System.out.println("判定は・・・" + correct);
        if ( correct ) {
            System.out.println("正解です !");
        }else{
            System.out.println("不正解です!");

        }
    }
}
