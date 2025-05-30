import java.util.Scanner;

public class JKad13S {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("私は量子コンピューターECCトロピカルよ！");
        int a;
        int i = 1;

        while (true) {
            System.out.print("なんの段を教えてほしいの？>");

            a = in.nextInt();

            if (9 < a) {
                System.out.println("そんな難しいの、わかんないわ！");
                continue;
            } else if (a <= 0) {
                System.out.println("さよなら！");
                break;
            } else {
                for (i = 1; i <= 9; i++ ){
                    System.out.print("\t"+a * i);
                }
                System.out.println();
            }
        }
    }
}










