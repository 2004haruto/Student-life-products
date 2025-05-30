public class Stack {
    private Monster[] container;
    private int sp;

    public Stack(int size) {
        container = new Monster[size];
        sp = 0;
    }
    public void push(Monster data) { container[sp++] = data; }
    public Monster pop() { return container[--sp]; }
    public Monster get(int i) { return container[i]; }
    public int size() { return sp; }
    public boolean empty() { return (sp <= 0); }
    public boolean full() { return (sp >= container.length); }
}