/*
    �ۑ薼�FJ2Kad01B�u���C�`���E����I�v
    �쐬���F2023/09/26
    �쐬�ҁF���ؗz�l
 */

import java.util.Scanner;

public class J2Kad01B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        J2Kad01C.showData();
        System.out.println(J2Kad01C.name + "���i������!!");
        J2Kad01C.name = "���C�`���E";
        J2Kad01C.hp = 40;
        while (true) {
            J2Kad01C.showData();
            System.out.print("�ǂ����܂����H�i1�F�U������A2�F����A-1�F�I���j��");
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
