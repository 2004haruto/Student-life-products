package pac22d;

import java.util.ArrayList;
import java.util.List;

// メニュー単品
class MenuItem {
    private String name;
    private int price;

    public MenuItem(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void printItem() {
        System.out.println(name + "：" + price);
    }
}

// メニュー一覧
class MenuList {
    protected String title;
    protected List<MenuItem> menuList = new ArrayList<>();

    public MenuList(String title) {
        this.title = title;
    }

    public void add(MenuItem item) {
        menuList.add(item);
    }

    public void printList() {
        System.out.println();
        System.out.println(title);
        for (MenuItem item : menuList) {
            item.printItem();
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
