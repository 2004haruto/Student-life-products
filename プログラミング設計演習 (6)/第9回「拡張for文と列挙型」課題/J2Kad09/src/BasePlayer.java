public abstract class BasePlayer {
    public String name;
    public BasePlayer(String name) { this.name = name; }
    public String toString() { return name; }
    public Hand createHand() {
        switch(selectHand()) {
            case 0: return new Gu();
            case 1: return new Choki();
            case 2: return new Pa();
        }
        return null;
    }
    protected abstract int selectHand();
}
