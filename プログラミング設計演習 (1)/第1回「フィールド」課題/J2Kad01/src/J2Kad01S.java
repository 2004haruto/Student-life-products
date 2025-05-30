/*
    課題名：J2Kad01S「そうだ！ECC銀行へ行こう！！」
    作成日：2023/09/26
    作成者：正木陽斗
 */

import java.util.Scanner;

public class J2Kad01S {
    public static Scanner in = new Scanner(System.in);
    public static String meigi = "のび太";
    public static int kouzanum = 1234567;
    public static int zandaka = 0;
    public static int ansyounum = 1111;
    public static void main(String[] args) {
        System.out.println("そうだ！銀行へ行こう！！");
        gotoECCBank();
        System.out.println("ありがとうございました！");
    }
    public static void showAccount(){
        System.out.println("口座名義:"+meigi);
        System.out.println("口座番号:"+kouzanum);
        System.out.println("預金残高:"+zandaka);
    }
    public static void gotoECCBank() {
        System.out.println("信頼と実績のECC 銀行へようこそ！");
        while (true) {
            showAccount();
            System.out.print("どうしますか（1：預ける、2：引き出す、-1：帰る）＞");
            int num1 = in.nextInt();
            if (num1 == 1) {
                deposit();
            } else if (num1 == 2) {
                withdraw();
            } else if (num1 == -1) {
                break;
            }
        }
    }
    public static void deposit(){
        System.out.print("いくら預けますか？＞");
        int num2 = in.nextInt();
        zandaka = zandaka + num2;
    }

    public static void withdraw(){
        System.out.print("暗証番号を入力してください＞");
        int num3 = in.nextInt();
        if (num3 != ansyounum){
            System.out.println("番号が違います！");

        }else{
            System.out.print("いくら引き出しますか？＞");
            int num4 = in.nextInt();
            if (num4 > zandaka){
                System.out.println("残高不足です！");
            }else {
                zandaka = zandaka - num4;
            }
        }
    }
}


