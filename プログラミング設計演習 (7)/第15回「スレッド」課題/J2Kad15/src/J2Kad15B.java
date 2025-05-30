/*
	課題名：J2Kad15B「そうだ！銀行へ行こう！！（スレッド版）」
	作成日：2023/11/16
	作成者：田中太郎
*/

import java.util.ArrayList;

//Bankクラス
class Bank{
    private static int money = 0;

    public static int getMoney(){
        return money;
    }
    //synchronizedをつければ順番に実行してくれる

    public synchronized  static void addOneYen(){
        money++;
    }
}

//Customerクラス
class Customer extends Thread{
    public Customer(){
        System.out.println("預金者がやってきた！「がんばってお金を預けるぞ！」");
    }

    public void run(){
        for (int i = 1;i <= 10000;i++){
            Bank.addOneYen();//一円預ける
        }
    }
}

public class J2Kad15B {
    public static void main(String[] args) {
        System.out.println("お金を預けるのなら信用と信頼のECC銀行へ！");

        // 預金者の募集
        Customer[] customers = new Customer[100];
//        ArrayList<Customer> customerList = new ArrayList<>();

            //配列バージョン
        for (int i = 0;i < 100;i++){
            customers[i] = new Customer();
        }
//            //ArrayListバージョン
//        for (int i = 0;i < 100;i++){
//            customerList.add(new Customer());
//        }

        // 預金スタート
        //左側に順番に取り出した値を入れる箱の宣言　右側に元の配列(コレクション)
        for (Customer c: customers){
            c.start();
        }
//        //ArrayList
//        for (Customer c : customerList){
//            c.start();
//        }

        // スレッド処理の終了待ち
        for (Customer c: customers){
            try {
                c.join();
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }

        // 預金額の表示
        System.out.println("預金額は"+Bank.getMoney()+"円です!");


    }
}
