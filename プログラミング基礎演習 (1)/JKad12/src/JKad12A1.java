import java.util.Scanner;

public class JKad12A1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("ひとつめの整数を入力してください>");
        int a = in.nextInt();
        System.out.print("ふたつめの整数を入力してください>");
        int b = in.nextInt();
        while (true){
            if(a>b) {
                a -= b;
            }else if (b>a){
                b -= a;
            }else{
                System.out.println("最大公約数は"+a+"です!");
                break;

            }
        }
    }
}
