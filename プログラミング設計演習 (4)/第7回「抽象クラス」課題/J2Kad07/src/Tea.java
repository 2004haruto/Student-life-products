public class Tea extends HotDrink {
    public void execute() {
        boilWater();
        steepTeabag();
        pourInCup();
    }
    public void boilWater() { System.out.println("お湯を沸かしました！"); }
    public void steepTeabag() { System.out.println("ティーバッグを浸しました！"); }
    public void pourInCup() { System.out.println("カップに注ぎました！"); }

    @Override
    public void drink() {

    }
}