/*
    �ۑ薼�FJ2Kad01S�u�������IECC��s�֍s�����I�I�v
    �쐬���F2023/09/26
    �쐬�ҁF���ؗz�l
 */

import java.util.Scanner;

public class J2Kad01S {
    public static Scanner in = new Scanner(System.in);
    public static String meigi = "�̂ё�";
    public static int kouzanum = 1234567;
    public static int zandaka = 0;
    public static int ansyounum = 1111;
    public static void main(String[] args) {
        System.out.println("�������I��s�֍s�����I�I");
        gotoECCBank();
        System.out.println("���肪�Ƃ��������܂����I");
    }
    public static void showAccount(){
        System.out.println("�������`:"+meigi);
        System.out.println("�����ԍ�:"+kouzanum);
        System.out.println("�a���c��:"+zandaka);
    }
    public static void gotoECCBank() {
        System.out.println("�M���Ǝ��т�ECC ��s�ւ悤�����I");
        while (true) {
            showAccount();
            System.out.print("�ǂ����܂����i1�F�a����A2�F�����o���A-1�F�A��j��");
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
        System.out.print("������a���܂����H��");
        int num2 = in.nextInt();
        zandaka = zandaka + num2;
    }

    public static void withdraw(){
        System.out.print("�Ïؔԍ�����͂��Ă���������");
        int num3 = in.nextInt();
        if (num3 != ansyounum){
            System.out.println("�ԍ����Ⴂ�܂��I");

        }else{
            System.out.print("����������o���܂����H��");
            int num4 = in.nextInt();
            if (num4 > zandaka){
                System.out.println("�c���s���ł��I");
            }else {
                zandaka = zandaka - num4;
            }
        }
    }
}


