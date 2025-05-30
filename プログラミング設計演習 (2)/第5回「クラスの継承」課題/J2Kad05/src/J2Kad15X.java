/*
	課題名：J2Kad05X「ECC苦情処理センター②」
	作成日：2023/10/10
	作成者：田中太郎
*/
import java.util.Scanner;

public class J2Kad15X {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("ここはECC苦情処理センターです！");
        System.out.println("優秀なスタッフが対応します！");
        System.out.println();

        Nobita nobita = new Nobita();
        Jaian jaian = new Jaian();
        Suneo suneo = new Suneo();
        Dekisugi dekisugi = new Dekisugi();
        System.out.println();

        while(true) {
            int n = (int)(Math.random() * 100);
            System.out.println("苦情番号：" + n + "を受け付けた！");
            System.out.print("どうしますか？（1：対応する、それ以外：もうやだ）＞");
            int cmd = in.nextInt();
            if (cmd != 1) break;

            if (!nobita.handle(n)) {
                if (!jaian.handle(n)) {
                    if (!suneo.handle(n)) {
                        dekisugi.handle(n);
                    }
                }
            }
            System.out.println();
        }
        System.out.println("おつかれさまでした！");
        in.close();
    }
}
