/*
    課題名：J2Kad03B「アクセサ」
    作成日：2023/10/03
    作成者：正木陽斗
 */
public class J2Kad03B {
    public static void main(String[] args) {
        Profile dora = new Profile("ドラえもん",129.3,129.3);
        Profile dorami = new Profile("ドラミちゃん",100.0,91.0);
        System.out.println(dora.getName()+"のプロフィールです！");
        System.out.println("身長:"+dora.getHeight());
        System.out.println("体重:"+dora.getWeight());
        System.out.println(dorami.getName()+"のプロフィールです!");
        System.out.println("身長:"+dorami.getHeight());
        System.out.println("体重:"+dorami.getWeight());
    }
}
