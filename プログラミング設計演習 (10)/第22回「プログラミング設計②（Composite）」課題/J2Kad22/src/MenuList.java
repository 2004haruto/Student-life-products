import java.util.ArrayList;
import java.util.List;

// メニュー単品
class MenuItem implements Component {
    private String name;
    private int price;

    public MenuItem(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void display() {
        System.out.println(name + "：" + price + " 円");
    }
}

// Component インターフェイス
interface Component {
    void display();
}

// メニュー一覧
class MenuList implements Component {
    protected String title;
    protected List<Component> menuList = new ArrayList<>();

    public MenuList(String title) {
        this.title = title;
    }

    public void add(Component item) {
        menuList.add(item);
    }

    @Override
    public void display() {
        System.out.println();
        System.out.println(title);
        for (Component item : menuList) {
            item.display();
        }
    }
}

// モーニングメニュー
class MorningMenu extends MenuList {
    public MorningMenu() {
        super("★ モーニングメニュー ★");
        add(new MenuItem("モーニングセット", 400));
        add(new MenuItem("焼き魚定食", 600));
    }
}

// ランチメニュー
class LunchMenu extends MenuList {
    public LunchMenu() {
        super("★ ランチメニュー ★");
        add(new MenuItem("日替わりランチ", 680));
        add(new MenuItem("シェフのおすすめランチ", 890));

        // ドリンクメニューをサブメニューとして追加
        DrinkMenu drinkMenu = new DrinkMenu();
        add(drinkMenu);
    }
}

// ディナーメニュー
class DinnerMenu extends MenuList {
    public DinnerMenu() {
        super("★ ディナーメニュー ★");
        add(new MenuItem("和風ハンバーグ", 680));
        add(new MenuItem("サーロインステーキ", 1180));

        // ドリンクメニューをサブメニューとして追加
        DrinkMenu drinkMenu = new DrinkMenu();
        add(drinkMenu);

        // デザートメニューをサブメニューとして追加
        DessertMenu dessertMenu = new DessertMenu();
        add(dessertMenu);
    }
}

// ドリンクメニュー
class DrinkMenu extends MenuList {
    public DrinkMenu() {
        super("＊ ドリンクメニュー ＊");
        add(new MenuItem("コーヒー", 220));
        add(new MenuItem("紅茶", 220));
    }
}

// デザートメニュー
class DessertMenu extends MenuList {
    public DessertMenu() {
        super("＊ デザートメニュー ＊");
        add(new MenuItem("チーズケーキ", 350));
        add(new MenuItem("アイスクリーム", 150));
    }
}