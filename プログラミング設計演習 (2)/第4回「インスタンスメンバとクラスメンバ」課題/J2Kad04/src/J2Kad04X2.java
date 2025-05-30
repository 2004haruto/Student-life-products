/*
    課題名：J2Kad04X2「レジ待ち行列②」
    作成日：2023/10/05
    作成者：田中太郎
 */
import java.util.Scanner;

public class J2Kad04X2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("いらっしゃい！激安スーパーECC2号店です！！");
        Stack line = new Stack(5);

        while(true) {
            // データの表示
            if (!line.empty()) {
                System.out.println("現在のレジ待ち行列です！");
                for (int i = 0; i < line.size(); i++) {
                    System.out.println(i + "：" + line.get(i));
                }
                System.out.println();
            }

            // コマンド選択
            System.out.print("何をしますか？（0：客を呼び込む、1：レジを打つ、-1：店をたたむ）＞");
            int cmd = in.nextInt();
            if (cmd < 0) break;

            switch (cmd) {
                case 0:			// 客を呼び込む
                    Monster	m = new Monster();
                    if (line.full()) {
                        System.out.println("もう店に入れない！残念！！");
                    }
                    else {
                        line.push(m);
                    }
                    break;
                case 1:			// レジを打つ
                    if (line.empty()) {
                        System.out.println("お客さんがいない！！");
                    }
                    else {
                        System.out.println(line.pop() + "は帰っていった！！");
                    }
                    break;
            }
            System.out.println();
        }
        System.out.println();
    }
}
