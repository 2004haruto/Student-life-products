public class Stack {
    protected Sheep[] container;
    protected int sp;
    public Stack(int size) {
        container = new Sheep[size];
        sp = 0;
    }
    public void push(Sheep data) { container[sp++] = data; }
    public Sheep pop() { return container[--sp]; }
    public Sheep get(int i) { return container[i]; }
    public int size() { return sp; }
    public boolean empty() { return (sp <= 0); }
    public boolean full() { return (sp >= container.length); }
}