package example;

public class Example06 {
    public static void main(String[] args) {
        //それぞれのクラスから親クラス型に変更
        Pirate luffy = new Luffy("ルフィ");
        Pirate zoro = new Zoro("ゾロ");
        Pirate sanji = new Sanji("サンジ");
        luffy.attack();
        zoro.attack();
        sanji.attack();


    }

    public static void attack(Pirate p){
        p.attack();
        p.attack();
        p.attack();
    }

}
