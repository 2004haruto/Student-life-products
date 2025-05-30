/*
	課題名：J2Kad08D「抽象クラスとインターフェイス」
	作成日：2023/10/19
	作成者：田中太郎
*/
import java.util.Scanner;

public class J2Kad08D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("妖精を召喚して自己紹介させます！");

        while(true) {
            System.out.print("誰を召喚しますか？（0：光の妖精、1：闇の妖精、2：炎の妖精、-1：やめる）＞");
            int n = in.nextInt();
            if (n < 0) break;

            switch(n) {
                default:
                case 0:
                    Light light = new Light();
                    light.intro();
                    break;
                case 1:
                    Darkness dark = new Darkness();
                    dark.intro();
                    break;
                case 2:
                    Fire fire = new Fire();
                    fire.intro();
                    break;
            }

            System.out.println();
        }
    }
}
