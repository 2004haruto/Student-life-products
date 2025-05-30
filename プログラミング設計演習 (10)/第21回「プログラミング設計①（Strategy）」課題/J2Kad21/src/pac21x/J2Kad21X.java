/*
	課題名：J2Kad21X「ポケットDuck！」
	作成日：2023/12/12
	作成者：田中太郎
*/
package pac21x;

import java.util.Scanner;

public class J2Kad21X {
    public static void main(String[] args) {
        System.out.println("ポケットDuckへようこそ！");
        System.out.println("がんばって野鳥をゲットしよう！！");
        System.out.println();

        Scanner in = new Scanner(System.in);

        while(true) {
            System.out.print("どの野鳥をゲットしますか？（0：アヒル、1：カラス、2：カモメ、3：ニワトリ、-1：終了）＞");
            int type = Integer.parseInt(in.next());
            if (type < 0) break;

            Bird bird;
            switch(type) {
                default:
                case 0: bird = new Duck();      break;
                case 1: bird = new Crow();      break;
                case 2: bird = new Seagull();   break;
                case 3: bird = new Chicken();   break;
            }
            System.out.println();

            while(true) {
                System.out.print("何をさせますか？（0：飛ぶ、1：泳ぐ、2：進化、-1：終了）＞");
                int cmd = Integer.parseInt(in.next());
                if (cmd < 0) break;

                switch(cmd) {
                    case 0: bird.fly();     break;
                    case 1: bird.swim();    break;
                    case 2: bird.evolve();  break;
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
