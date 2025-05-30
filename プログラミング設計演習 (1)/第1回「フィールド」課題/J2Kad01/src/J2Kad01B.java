/*
    課題名：J2Kad01B「ライチュウ現る！」
    作成日：2023/09/26
    作成者：正木陽斗
 */

import java.util.Scanner;

public class J2Kad01B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        J2Kad01C.showData();
        System.out.println(J2Kad01C.name + "が進化した!!");
        J2Kad01C.name = "ライチュウ";
        J2Kad01C.hp = 40;
        while (true) {
            J2Kad01C.showData();
            System.out.print("どうしますか？（1：散歩する、2：眠る、-1：終了）＞");
            int num = in.nextInt();
            if (num == 1) {
                J2Kad01C.walk();
            } else if (num == 2) {
                J2Kad01C.sleep();
            } else if (num == -1) {
                break;
            }
        }
    }
}
