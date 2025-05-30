import java.util.Scanner;

public class JKad10S {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("こんにちは!");
        System.out.println("わたしはスーパーティーチャー、ECCエクセレントよ!");
        System.out.print("あなたのコースを教えてね!　(1:IE、2:SK、3:SE)>");
        int a = sc.nextInt();
        if (a != 1 && a !=2 && a !=3) {
            System.out.println("ちゃんと答えてね!");
        }
        if (a == 1) {
            System.out.print("いま何年生?");
            int b = sc.nextInt();
            if (b >= 1 && b <= 4) {
                System.out.println("ITカレッジの学生さん、よろしくね!");
            } else {
                System.out.println("IEは4年制コースよ!");
            }
        }
        if (a == 2) {
            System.out.print("いま何年生?");
            int b = sc.nextInt();
            if (b >= 1 && b <= 3) {
                System.out.println("ITカレッジの学生さん、よろしくね!");
            } else {
                System.out.println("SKは3年制コースよ!");
            }
        }
        if (a == 3) {
            System.out.print("いま何年生?");
            int b = sc.nextInt();
            if (b >= 1 && b <= 2) {
                System.out.println("ITカレッジの学生さん、よろしくね!");
            } else {
                System.out.println("SEは2年制コースよ!");
            }
        }
    }
}