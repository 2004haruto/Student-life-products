import java.util.Scanner;

public class JKad10X {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int random = (int) (Math.random() * 3);
        System.out.println("じゃんけんをします！");
        System.out.print("何の手を出しますか？（0：グー、1：チョキ、2：パー）＞");
        int a = in.nextInt();
        if ( a==0 ) {
            System.out.println("あなたはグーを出した！");
        }else if ( a==1 ){
            System.out.println("あなたはチョキを出した！");
        }else if ( a==2 ){
            System.out.println("あなたはパーを出した！");
        }
        if ( random==0 ){
            System.out.println("コンピュータはグーを出した！");
        }else if ( random==1 ){
            System.out.println("コンピュータはチョキを出した！");
        } else if ( random==2 ){
            System.out.println("コンピュータはパーを出した！");
        }
        if ( a==0 && random==0 ){
            System.out.println("あいこだ!");
        }else if ( a==0 && random==1 ){
            System.out.println("あなたの勝ち！");
        }else if ( a==0 && random==2) {
            System.out.println("あなたの負け！");
        }
        if ( a==1 && random==0 ){
            System.out.println("あなたの負け！");
        }else if ( a==1 && random==1 ){
            System.out.println("あいこだ!");
        }else if ( a==1 && random==2) {
            System.out.println("あなたの勝ち！");
        }
        if ( a==2 && random==0 ){
            System.out.println("あなたの勝ち！");
        }else if ( a==2 && random==1 ){
            System.out.println("あなたの負け！");
        }else if ( a==2 && random==2) {
            System.out.println("あいこだ!");
        }
    }
}
