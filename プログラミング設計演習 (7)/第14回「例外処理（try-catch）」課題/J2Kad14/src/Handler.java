public abstract class Handler {
    private String name;
    public Handler(String name) {
        this.name = name;
        System.out.println(this.name + "がスタンバイした！");
    }
    public boolean handle(int n) {
        if (resolve(n)) {
            System.out.println(name + "：私が対応します！");
            return true;
        }
        System.out.println(name + "：専門外です・・・");
        return false;
    }
    protected abstract boolean resolve(int n);
}
