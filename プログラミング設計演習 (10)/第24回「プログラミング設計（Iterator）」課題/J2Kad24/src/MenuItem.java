public class MenuItem {
    private String name;
    private int price;
    public MenuItem(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public void print() { System.out.println(name + "：" + price + "円"); }
}
// MenuIteratorインターフェイス
interface MenuIterator{
    //全て抽象メソッドのなる
    //public abstractが省略されている
    boolean hasNext();
    MenuItem next();
}

// Menuインターフェイス
interface Menu{
    MenuIterator iterator();
}

