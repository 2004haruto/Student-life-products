/*
	課題名：J2Kad06A「妖精の召喚」
	作成日：2023/10/12
	作成者：田中太郎
*/
import java.util.Scanner;

public class J2Kad06A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("妖精を召喚して自己紹介させます！");
        Fairy [] fairies = {new Fire(),new Light(),new Darkness()};
        while(true) {
            System.out.print("どうしますか？（0：召喚する、-1：やめる）＞");
            int cmd = in.nextInt();
            if (cmd < 0) break;
            int n = (int)(Math.random() * 3);
            fairies[n].intro();
/*
            Fairy f;

            // 妖精の召喚
            int n = (int)(Math.random() * 3);
            switch(n) {
                default:
                case 0:
                    f = new Light();
                    break;
                case 1:
                    f = new Darkness();
                    break;
                case 2:
                    f = new Fire();
                    break;
            }

            f.intro();

 */
            System.out.println();
        }
    }
}
