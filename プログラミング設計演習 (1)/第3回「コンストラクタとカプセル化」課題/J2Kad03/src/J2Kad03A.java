/*
    課題名：J2Kad03A「スタック！③」
    作成日：2023/10/03
    作成者：田中太郎
 */
import java.util.Scanner;

public class J2Kad03A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("スタック操作をします！");
        Stack s = new Stack();
        s.stack = new int[10];  // スタックサイズの設定
        s.sp = 0;               // スタックポインタ（最初は0）

        while(true) {
            System.out.print("どうしますか？（1：push、2：pop、-1：終了）＞");
            int cmd = in.nextInt();
            if (cmd < 0) break;

            switch(cmd) {
                case 1:
                    if (s.sp >= s.stack.length) {
                        System.out.println("スタックがいっぱいです！");
                    } else {
                        s.push((int)(Math.random() *100));
                    }
                    break;
                case 2:
                    if (s.sp <= 0) {
                        System.out.println("データがありません！");
                    } else {
                        System.out.println(s.pop() + "を取り出しました！");
                    }
                    break;
            }

            System.out.print("stack：");
            for (int i = 0; i < s.sp; i++) {
                System.out.print(s.stack[i] + " ");
            }
            System.out.println();
            System.out.println();
        }
    }
}