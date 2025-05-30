public class BasePlayer {
    protected String name;
    public BasePlayer() { name = "CPU"; }
    public void intro() { System.out.println("名前：" + name + "・・・" + myStrategy()); }
    public String toString() { return name; }
    public int takeStone(int stone) {
        int n = 1 + (int)(Math.random() * 3);
        return Math.min(n, stone);
    }
    protected String myStrategy() { return "取る石の数を乱数で決めます。"; }
}
