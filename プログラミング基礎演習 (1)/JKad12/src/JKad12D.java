
import java.util.Scanner;
public class JKad12D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("リンゴの数を入力してください＞");
        int apple = in.nextInt();
        System.out.print("食べる人の数を入力してください＞");
        int person = in.nextInt();
        while(apple >= person) {
                System.out.println("ひとり一つずつリンゴを食べた！");
                apple -= person;

        }

        System.out.println("それぞれ" + (person/apple) + "個のリンゴを食べました!");
            System.out.println("残ったリンゴは" + apple + "個です！");
            in.close();
    }
}

