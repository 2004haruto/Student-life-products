class MenuItem {
    protected String name;
    protected int price;
    public MenuItem(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public String getName() { return name; }
    public int getPrice() { return price; }
}
class HouseBlend extends MenuItem {
    public HouseBlend() { super("ブレンドコーヒー", 380); }
}
class Espresso extends MenuItem {
    public Espresso() { super("エスプレッソ", 320); }
}
class DarkRoast extends MenuItem {
    public DarkRoast() { super("深煎りコーヒー", 400); }
}
// 豆乳入り
class HouseBlendSoy extends MenuItem {
    public HouseBlendSoy() { super("ブレンドコーヒー＋豆乳", 380 + 40); }
}
class EspressoSoy extends MenuItem {
    public EspressoSoy() { super("エスプレッソ＋豆乳", 320 + 40); }
}
class DarkRoastSoy extends MenuItem {
    public DarkRoastSoy() { super("深煎りコーヒー＋豆乳", 400 + 40); }
}
// ホイップクリーム入り
class HouseBlendWhip extends MenuItem {
    public HouseBlendWhip() { super("ブレンドコーヒー＋ホイップ", 380 + 50); }
}
class EspressoWhip extends MenuItem {
    public EspressoWhip() { super("エスプレッソ＋ホイップ", 320 + 50); }
}
class DarkRoastWhip extends MenuItem {
    public DarkRoastWhip() { super("深煎りコーヒー＋ホイップ", 400 + 50); }
}
// ココア入り
class HouseBlendCocoa extends MenuItem {
    public HouseBlendCocoa() { super("ブレンドコーヒー＋ココア", 380 + 30); }
}
class EspressoCocoa extends MenuItem {
    public EspressoCocoa() { super("エスプレッソ＋ココア", 320 + 30); }
}
class DarkRoastCocoa extends MenuItem {
    public DarkRoastCocoa() { super("深煎りコーヒー＋ココア", 400 + 30); }
}
// デコレータ


