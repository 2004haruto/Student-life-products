public class Jaian {
    public Jaian() {
        System.out.println("ジャイアンがスタンバイした！");
    }
    public boolean handle(int n) {
        if ((n % 5) == 0) {
            System.out.println("ジャイアン：私が対応します！");
            return true;
        }
        System.out.println("ジャイアン：専門外です・・・");
        return false;
    }
}
