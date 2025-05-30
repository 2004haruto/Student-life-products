public class Monster {
    protected String name;
    public Monster() { System.out.println("Monsterクラスのコンストラクタが呼び出されました！"); }
    public void setName(String name) {
        this.name = name;
    }
    public void intro() {
        System.out.println("おいらの名前は" + name + "。");
        System.out.println("趣味は散歩。特技はどこでも眠れることだよ。");
    }
    public void walk() {
        System.out.println("てくてく・・・");
    }
    public void sleep() {
        System.out.println("ぐうぐう・・・");
    }
}
