import java.util.Scanner;

public class JKad13C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a ;
        int b = 0;
        int c  = 0;

        do {
            System.out.print("1 より大きい整数を入力してください>");
            a=in.nextInt();

        }while ( a<=1 ) ;
         while (b<a) {
             b++;
             c += b;

         }
        System.out.println("1から"+ a + "まで加算します !");
        System.out.println("合計は" + c + "です!!");
    }
}


