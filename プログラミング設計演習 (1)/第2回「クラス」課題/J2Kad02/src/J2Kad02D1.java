/*
    課題名：J2Kad02D1「ピカチュウクラス！」
    作成日：2023/09/28
    作成者：正木陽斗
 */

public class J2Kad02D1 {

    public static void main(String[] args) {
        Pika.showData();

        System.out.println(Pika.name + "を散歩させます！");
        Pika.walk();
        Pika.walk();
        Pika.walk();
        Pika.showData();

        System.out.println(Pika.name + "を眠らせます！");
        Pika.sleep();
        Pika.sleep();
        Pika.sleep();
        Pika.showData();
    }
}

