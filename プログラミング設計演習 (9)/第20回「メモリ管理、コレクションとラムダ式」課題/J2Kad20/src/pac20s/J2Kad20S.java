/*
	課題名：J2Kad20S「シネコンECC①（Singleton）」
	作成日：2023/12/07
	作成者：田中太郎
*/
package pac20s;

import java.util.Scanner;

public class J2Kad20S {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("ようこそ！シネコンECCへ！");
        SalesPerson[] w = {
                new SalesPerson("のび太"),
                new SalesPerson("スネ夫"),
                new SalesPerson("ジャイアン"),
        };

        while (true) {
            System.out.print("何番の窓口で購入しますか？（0～2、-1：終了）＞");
            int i = Integer.parseInt(in.next());
            if (i < 0) break;

            w[i].intro();
            w[i].issueTicket();
            System.out.println();
        }
    }
}
// 発券機
class TicketMaker {
    private int ticket;
    public TicketMaker() { ticket = 0; }
    public int next() { return ++ticket; }
}
// 窓口
class SalesPerson {
    private String name;                        // 担当者名
    private TicketMaker t = new TicketMaker();  // 発券機
    public SalesPerson(String name) {
        this.name = name;
    }
    public void intro() {
        System.out.println(name + "が担当します！");
    }
    public void issueTicket() {
        System.out.println("あなたの座席は" + t.next() + "番です！");
    }
}
