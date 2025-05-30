import java.util.Scanner;

public class JKad09D2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("こんにちは！");
        System.out.println("わたしはスーパーティーチャー、ECCエクセレントよ！");
        System.out.print("あなたのクラスを教えてね！（1:IE、2:SK、3:SE)>");
        int a = sc.nextInt();
        if ( a == 1 ) {
            System.out.println("4年制コースなのね！");
        }
        if ( a == 2 ) {
            System.out.println("3年制コースなのね！");
        }
        if ( a == 3 ) {
            System.out.println("2年制コースなのね！");
        }
    }
}
