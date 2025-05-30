/*
	課題名：J2Kad14X「ECC苦情処理センター（Chain of Responsibility）」
	作成日：2023/11/14
	作成者：田中太郎
*/
import java.util.Scanner;

public class J2Kad14X {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("ここはECC苦情処理センターです！");
        System.out.println("優秀なスタッフが対応します！");
        // 初期メンバー
        Nobita nobita = new Nobita();
        Jaian jaian = new Jaian();
        Suneo suneo = new Suneo();

        Sizuka sizuka = null;
        Dekisugi dekisugi = null;

        boolean helper = false;

        while(true) {
            System.out.println();
            System.out.print("どうしますか？（0：苦情を受け取る、1：応援を頼む、-1：もうやだ）＞");
            int cmd = in.nextInt();
            if (cmd < 0) break;
            // 応援を頼む
            if (cmd == 1) {
                if (!helper) {
                    sizuka = new Sizuka();
                    dekisugi = new Dekisugi();
                    helper = true;
                }
                continue;
            }
            // 苦情処理
            int n = (int)(Math.random() * 100);
            System.out.println("苦情番号：" + n + "を受け付けた！");
            if (!nobita.handle(n)) {
                if (!jaian.handle(n)) {
                    if (!suneo.handle(n)) {
                        if (helper) {
                            if (!sizuka.handle(n)) {
                                dekisugi.handle(n);
                            }
                        }
                    }
                }
            }
        }
        System.out.println("おつかれさまでした！");
    }
}
