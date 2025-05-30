/*
    課題名：J2Kad01A「2回目のおつかい」
    作成日：2023/09/26
    作成者：正木陽斗
 */
public class J2Kad01A {
    public static int money = 1000;
    public static void main(String[] args) {
        System.out.println("2 回目のおつかい！");
        System.out.println("のび太がハンバーガーとドーナツとコーヒーを買いに行きます！");
        showMoney();
        gotoECCBurger();
        showMoney();
        gotoECCDonut();
        showMoney();
        gotoECCCoffee();
        showMoney();
    }
    public static void showMoney(){
        System.out.println("所持金は"+money+"です。");
    }
    public static void gotoECCBurger(){
        System.out.println("ECC バーガーに着きました！");
        System.out.println("ハンバーガー200 円を買いました！");
        money = money - 200;
    }
    public static void gotoECCDonut(){
        System.out.println("ECC ドーナツに着きました！");
        System.out.println("ドーナツ120 円を買いました！");
        money = money - 120;
    }
    public static void gotoECCCoffee(){
        System.out.println("ECC コーヒーに着きました!");
        System.out.println("コーヒー350 円を買いました！");
        money = money - 350;
    }
}
