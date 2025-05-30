public class Monster {
    protected String name;          //private String name;
    public Monster(String name) { this.name = name; }
    public void intro() {
        System.out.println("おいらの名前は" + name + "。");
        System.out.println("趣味は散歩。特技はどこでも眠れることだよ。");
    }
}
