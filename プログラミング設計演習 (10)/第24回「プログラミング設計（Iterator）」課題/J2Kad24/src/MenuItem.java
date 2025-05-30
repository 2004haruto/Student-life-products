public class MenuItem {
    private String name;
    private int price;
    public MenuItem(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public void print() { System.out.println(name + "�F" + price + "�~"); }
}
// MenuIterator�C���^�[�t�F�C�X
interface MenuIterator{
    //�S�Ē��ۃ��\�b�h�̂Ȃ�
    //public abstract���ȗ�����Ă���
    boolean hasNext();
    MenuItem next();
}

// Menu�C���^�[�t�F�C�X
interface Menu{
    MenuIterator iterator();
}

