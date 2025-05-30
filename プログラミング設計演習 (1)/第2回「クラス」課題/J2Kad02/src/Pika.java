public class Pika {
    public static String name = "ピカチュウ";    // 名前
    public static int hp = 20;                  // 体力
    public static void showData() {
        System.out.println("ぼくの名前は" + name + "！HPは" + hp + "だよ！");
    }
    public static void walk() {
        System.out.println("てくてく・・・");
        hp--;
    }
    public static void sleep() {
        System.out.println("ぐうぐう・・・");
        hp++;
    }
}
