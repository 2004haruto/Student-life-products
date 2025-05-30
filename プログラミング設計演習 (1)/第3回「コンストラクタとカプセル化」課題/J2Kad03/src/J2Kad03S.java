/*
    課題名：J2Kad03S「そうだ！ECC銀行へ行こう！！③」
    作成日：2023/10/03
    作成者：田中太郎
 */
import java.util.Scanner;

public class J2Kad03S {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("そうだ！銀行へ行こう！！");
        Account nobita = new Account();
        nobita.name = "のび太";
        nobita.accountNumber = 1234567;
        nobita.money = 0;
        nobita.secretNumber = 1234;

        Account suneo = new Account();
        suneo.name = "スネ夫";
        suneo.accountNumber = 8901234;
        suneo.money = 10000000;
        suneo.secretNumber = 5678;

        while(true) {
            System.out.print("誰が行きますか？（1：のび太、2：スネ夫、-1：誰もいかない）＞");
            int accNo = in.nextInt();
            if (accNo < 0) break;

            Account account = (accNo == 1)? nobita : suneo;
            gotoECCBank(account);
            System.out.println();
        }
    }
    public static void gotoECCBank(Account account) {
        System.out.println("ECC銀行梅田本店へようこそ！");
        while(true) {
            System.out.println("口座名義：" + account.name);
            System.out.println("口座番号：" + account.accountNumber);
            System.out.println("預金残高：" + account.money + "円");

            System.out.print("どうしますか？（1：預ける、2：引き出す、-1：終了）＞");
            int cmd = in.nextInt();
            if (cmd < 0) break;

            switch(cmd) {
                case 1: deposit(account);  break;
                case 2: withdraw(account); break;
            }
            System.out.println();
        }
        System.out.println("ありがとうございました！");
    }
    private static void deposit(Account account) {
        System.out.print("いくら預けますか？＞");
        int money = in.nextInt();
        account.money += money;
    }
    private static void withdraw(Account account) {
        System.out.print("暗証番号を入力してください＞");
        int secretNumber = in.nextInt();
        if (secretNumber != account.secretNumber) {
            System.out.println("番号が違います！");
            return;
        }
        System.out.print("いくら引き出しますか？＞");
        int money = in.nextInt();
        if (money > account.money) {
            System.out.println("残高不足です！");
            return;
        }
        account.money -= money;
    }
}
