public class Stack {
    public int[] stack;
    public int sp;
    public void push(int data) {
        stack[sp++] = data;
    }
    public int pop() {
        return stack[--sp];
    }
}