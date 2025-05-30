public class Nobita {
    public Nobita() {
        System.out.println("のび太がスタンバイした！");
    }
    public boolean handle(int n) {
        if (n < 20) {
            System.out.println("のび太：私が対応します！");
            return true;
        }
        System.out.println("のび太：専門外です・・・");
        return false;
    }
}
