/*
    �ۑ薼�FJ2Kad01A�u2��ڂ̂������v
    �쐬���F2023/09/26
    �쐬�ҁF���ؗz�l
 */
public class J2Kad01A {
    public static int money = 1000;
    public static void main(String[] args) {
        System.out.println("2 ��ڂ̂������I");
        System.out.println("�̂ё����n���o�[�K�[�ƃh�[�i�c�ƃR�[�q�[�𔃂��ɍs���܂��I");
        showMoney();
        gotoECCBurger();
        showMoney();
        gotoECCDonut();
        showMoney();
        gotoECCCoffee();
        showMoney();
    }
    public static void showMoney(){
        System.out.println("��������"+money+"�ł��B");
    }
    public static void gotoECCBurger(){
        System.out.println("ECC �o�[�K�[�ɒ����܂����I");
        System.out.println("�n���o�[�K�[200 �~�𔃂��܂����I");
        money = money - 200;
    }
    public static void gotoECCDonut(){
        System.out.println("ECC �h�[�i�c�ɒ����܂����I");
        System.out.println("�h�[�i�c120 �~�𔃂��܂����I");
        money = money - 120;
    }
    public static void gotoECCCoffee(){
        System.out.println("ECC �R�[�q�[�ɒ����܂���!");
        System.out.println("�R�[�q�[350 �~�𔃂��܂����I");
        money = money - 350;
    }
}
