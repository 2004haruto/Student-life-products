import java.util.Scanner;

public class JKad09C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ひとり一つずつリンゴを食べます！");
        System.out.print("リンゴの数を入力してください>");
        int a = sc.nextInt();
        System.out.print("食べる人の数を入力してください>");
        int b = sc.nextInt();
        if ( a<b ) {
            System.out.println("リンゴの数が足りません！");

        } else {
            System.out.println("ひとり一つずつリンゴを食べた！");
            System.out.println("残ったリンゴは" +( a-b )+ "です！");
        }
    }
}
