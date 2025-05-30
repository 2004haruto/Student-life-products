import java.util.Scanner;

public class JKad21A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] numbers = {1,2,3,4,5,6,7,8,9};

        System.out.print("¶¬‚·‚é®”‚ÌŒ…”‚ğ“ü—Í‚µ‚Ä‚­‚¾‚³‚¢i1`9j„");
        int num = in.nextInt();

        for (int i = 0; i < num; i++) {
            int adjust = numbers.length - i;
            int random = i + (int) (Math.random() * adjust);

            if (i == random) continue;

            int temp = numbers[i];
            numbers[i] = numbers[random];
            numbers[random] = temp;
        }

        String ranNum = "";
        for (int i = 0; i < num; i++){
            ranNum += numbers[i];
        }

        System.out.print(ranNum);
    }
}