/*
    課題名：J2Kad02A「参照渡し」
    作成日：2023/09/28
    作成者：正木陽斗
 */

public class J2Kad02A {
    public static void useMonster(Monster m){
        System.out.println(m.name+"を散歩させます！");
        m.walk();
        m.walk();
        m.walk();
        m.showData();
        System.out.println(m.name+"を眠らせます！");
        m.sleep();
        m.sleep();
        m.sleep();
        m.showData();
    }

    public static void main(String[] args) {
        int num1 = (int)(Math.random()*10)+10;
        int num2 = (int)(Math.random()*10)+10;
        Monster pikachu = new Monster();
        pikachu.setData("ピカチュウ",num1);
        pikachu.showData();
        Monster iwanko = new Monster();
        iwanko.setData("イワンコ",num2);
        iwanko.showData();
        useMonster(pikachu);
        useMonster(iwanko);
    }
}
