/*
    �ۑ薼�FJ2Kad02A�u�Q�Ɠn���v
    �쐬���F2023/09/28
    �쐬�ҁF���ؗz�l
 */

public class J2Kad02A {
    public static void useMonster(Monster m){
        System.out.println(m.name+"���U�������܂��I");
        m.walk();
        m.walk();
        m.walk();
        m.showData();
        System.out.println(m.name+"�𖰂点�܂��I");
        m.sleep();
        m.sleep();
        m.sleep();
        m.showData();
    }

    public static void main(String[] args) {
        int num1 = (int)(Math.random()*10)+10;
        int num2 = (int)(Math.random()*10)+10;
        Monster pikachu = new Monster();
        pikachu.setData("�s�J�`���E",num1);
        pikachu.showData();
        Monster iwanko = new Monster();
        iwanko.setData("�C�����R",num2);
        iwanko.showData();
        useMonster(pikachu);
        useMonster(iwanko);
    }
}
