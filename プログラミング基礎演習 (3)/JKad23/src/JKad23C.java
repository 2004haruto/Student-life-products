import java.util.Scanner;

public class JKad23C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("わたしはスーパーティーチャー、ECC エクセレントよ！");
        System.out.println("あなたのクラスを教えてね！");
        System.out.print("（1：IE、2：SK、3：SE、それ以外：わからない＞");
        int a = in.nextInt();
        switch (a){
            case 1:
                System.out.println("4年制コースなのね！");
                break;
            case 2:
                System.out.println("3年制コースなのね！");
                break;
            case 3:
                System.out.println("2年制コースなのね！");
                break;
            default:
                System.out.println("わからないのね！");
                break;
        }
    }
}
