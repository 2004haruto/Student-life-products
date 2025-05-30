/*
    �ۑ薼�FJ2Kad03S�u�������IECC��s�֍s�����I�I�B�v
    �쐬���F2023/10/03
    �쐬�ҁF�c�����Y
 */
import java.util.Scanner;

public class J2Kad03S {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("�������I��s�֍s�����I�I");
        Account nobita = new Account();
        nobita.name = "�̂ё�";
        nobita.accountNumber = 1234567;
        nobita.money = 0;
        nobita.secretNumber = 1234;

        Account suneo = new Account();
        suneo.name = "�X�l�v";
        suneo.accountNumber = 8901234;
        suneo.money = 10000000;
        suneo.secretNumber = 5678;

        while(true) {
            System.out.print("�N���s���܂����H�i1�F�̂ё��A2�F�X�l�v�A-1�F�N�������Ȃ��j��");
            int accNo = in.nextInt();
            if (accNo < 0) break;

            Account account = (accNo == 1)? nobita : suneo;
            gotoECCBank(account);
            System.out.println();
        }
    }
    public static void gotoECCBank(Account account) {
        System.out.println("ECC��s�~�c�{�X�ւ悤�����I");
        while(true) {
            System.out.println("�������`�F" + account.name);
            System.out.println("�����ԍ��F" + account.accountNumber);
            System.out.println("�a���c���F" + account.money + "�~");

            System.out.print("�ǂ����܂����H�i1�F�a����A2�F�����o���A-1�F�I���j��");
            int cmd = in.nextInt();
            if (cmd < 0) break;

            switch(cmd) {
                case 1: deposit(account);  break;
                case 2: withdraw(account); break;
            }
            System.out.println();
        }
        System.out.println("���肪�Ƃ��������܂����I");
    }
    private static void deposit(Account account) {
        System.out.print("������a���܂����H��");
        int money = in.nextInt();
        account.money += money;
    }
    private static void withdraw(Account account) {
        System.out.print("�Ïؔԍ�����͂��Ă���������");
        int secretNumber = in.nextInt();
        if (secretNumber != account.secretNumber) {
            System.out.println("�ԍ����Ⴂ�܂��I");
            return;
        }
        System.out.print("����������o���܂����H��");
        int money = in.nextInt();
        if (money > account.money) {
            System.out.println("�c���s���ł��I");
            return;
        }
        account.money -= money;
    }
}
