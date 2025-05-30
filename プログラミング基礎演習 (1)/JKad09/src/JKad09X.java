import java.util.Scanner;

public class JKad09X {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("こんにちは！");
        System.out.println("わたしはスーパーティーチャー、ECCエクセレントよ！");
        System.out.print("あなたのクラスを教えてね！（1:IE、2:SK、3:SE、それ以外:わからない)>");
        int a = in.nextInt();
        if ( a == 1 ) {
            System.out.println("4年制コースなのね！");
        }else if ( a == 2 ) {
            System.out.println("3年制コースなのね！");
        }else if ( a == 3 ) {
            System.out.println("2年制コースなのね！");
        }else{
            System.out.println("わからないのね!");
        }
    }
}


