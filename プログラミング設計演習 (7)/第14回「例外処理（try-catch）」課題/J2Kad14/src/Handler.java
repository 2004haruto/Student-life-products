public abstract class Handler {
    private String name;
    public Handler(String name) {
        this.name = name;
        System.out.println(this.name + "���X�^���o�C�����I");
    }
    public boolean handle(int n) {
        if (resolve(n)) {
            System.out.println(name + "�F�����Ή����܂��I");
            return true;
        }
        System.out.println(name + "�F���O�ł��E�E�E");
        return false;
    }
    protected abstract boolean resolve(int n);
}
