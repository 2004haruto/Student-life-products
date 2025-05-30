public class Suneo {
    public Suneo() {
        System.out.println("スネ夫がスタンバイした！");
    }
    public boolean handle(int n) {
        if ((n % 3) == 0) {
            System.out.println("スネ夫：私が対応します！");
            return true;
        }
        System.out.println("スネ夫：専門外です・・・");
        return false;
    }
}
