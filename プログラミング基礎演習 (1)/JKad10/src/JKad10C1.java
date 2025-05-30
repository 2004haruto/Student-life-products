import java.util.Scanner;

public class JKad10C1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("こんにちは!");
        System.out.println("わたしはスーパーティーチャー、ECCエクセレントよ!");
        System.out.print("あなたのコースを教えてね!　(1:IE、2:SK、3:SE)>");
        int a = sc.nextInt();
        if (1 <=a && a<=3) {
            System.out.println("ITカレッジの学生ね!");
        }else{
            System.out.println("ちゃんと答えてね!");
        }

    }
}
