public class Rocket2 extends Rocket{
    public Rocket2(int fuel,int height){
        super(fuel,height);
        System.out.println("新型エンジンだ！");
    }

    @Override
    public void useFuel() {
        if (fuel > 0) {
            System.out.println("燃料を使った！");
            speed -= 7;         // 逆噴射による減速
            fuel--;
        } else {
            System.out.println("燃料がない！");
        }
    }
}
