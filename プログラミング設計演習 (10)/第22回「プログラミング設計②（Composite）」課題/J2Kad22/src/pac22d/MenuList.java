package pac22d;

import java.util.ArrayList;
import java.util.List;

// ���j���[�P�i
class MenuItem {
    private String name;
    private int price;

    public MenuItem(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void printItem() {
        System.out.println(name + "�F" + price);
    }
}

// ���j���[�ꗗ
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

// ���[�j���O���j���[
class MorningMenu extends MenuList {
    public MorningMenu() {
        super("�� ���[�j���O���j���[ ��");
        add(new MenuItem("���[�j���O�Z�b�g", 400));
        add(new MenuItem("�Ă�����H", 600));
    }
}
