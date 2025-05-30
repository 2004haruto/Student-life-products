public class Queue extends Stack{

    public Queue(int size) {
        super(size);
    }
    public Sheep pop() {
        Sheep sheep = container[0];
        sp--;
        for (int i = 0; i < sp; i++) {
            container[i] = container[i + 1];
        }
        return sheep;
    }
}
