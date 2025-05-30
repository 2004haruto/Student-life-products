import java.util.Scanner;

public class JKad26D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("のび太は何を出しますか？（0：グー、1：チョキ、2：パー）＞");
        int a = in.nextInt();
        String[] strHands = {"グー", "チョキ", "パー"};
        System.out.println("のび太は"+strHands[a]+"を出した!");
        int b = (int)(Math.random()*3);
        System.out.println("しずかは"+strHands[b]+"を出した!");

    }
}
