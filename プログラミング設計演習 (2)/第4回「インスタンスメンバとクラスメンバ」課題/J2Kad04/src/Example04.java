public class Example04 {
    public static void main(String[] args) {
        Adventurer advA = new Adventurer("冒険者A","チームA");
        Adventurer advB = new Adventurer("冒険者B","チームB");
        advA.show();   //チームBで
        advB.show();
    }
}
