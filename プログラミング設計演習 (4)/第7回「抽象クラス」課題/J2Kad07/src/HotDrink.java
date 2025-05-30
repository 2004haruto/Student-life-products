public abstract class HotDrink {
    public void execute() {
        boilWater();
        drink();
        pourInCup();
        drink2();
    }
    public void boilWater() { System.out.println("お湯を沸かしました！"); }
    public void pourInCup(){System.out.println("カップに注ぎました！");}
    public  abstract void drink();
    public void drink2(){};
}