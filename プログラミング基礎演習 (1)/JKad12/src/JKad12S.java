import java.util.Scanner;

public class JKad12S {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("数当てゲーム!");
        int a = 0;
        int random = (int)(Math.random()*100);
        while (true){
            a++;
            System.out.print(a+"数値を入力してください>");
            int b = in.nextInt();
            if(random < b) {
                System.out.println(b + "より大きいです!");
            }else if(random>b) {
                System.out.println(b + "より小さいです!");
            }else{
                System.out.println("正解しました!");
                break;
            }
        }
    }
}
