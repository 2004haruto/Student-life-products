public class Monster {
    protected String name;
    public Monster(String name) {
        this.name = name;
        System.out.println(name + "がやってきた！");
    }
    public void intro() {
        System.out.println("おいらの名前は" + name + "。よろしくね！");
    }
    public void walk() {
        System.out.println("てくてく・・・");
    }
    public void sleep() {
        System.out.println("ぐうぐう・・・");
    }
}
