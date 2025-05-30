public class Rocket {
    protected int fuel;           // 燃料
    protected int height;         // 高度
    protected int speed;          // 落下速度
    public Rocket(int fuel, int height) {
        this.fuel = fuel;
        this.height = height;
        this.speed = 0;
        System.out.println("ロケットを作った！");
    }
    public int getSpeed() { return speed; }
    public int getHeight() { return height; }
    public void showData() {
        System.out.println("--------------------------------");
        System.out.println("[燃料]：" + fuel + "\t[落下速度]：" + speed + "\t[高度]：" + height);
        System.out.println("--------------------------------");
    }
    public void useFuel() {
        if (fuel > 0) {
            System.out.println("燃料を使った！");
            speed -= 5;         // 逆噴射による減速
            fuel--;
        } else {
            System.out.println("燃料がない！");
        }
    }
    public void move() {
        speed += 4;                 // 重力による加速
        height -= speed;            // 落下
    }
}
