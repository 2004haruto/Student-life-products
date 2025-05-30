import java.util.ArrayList;
import java.util.List;

// ���j���[�P�i
class MenuItem implements Component {
    private String name;
    private int price;

    public MenuItem(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void display() {
        System.out.println(name + "�F" + price + " �~");
    }
}

// Component �C���^�[�t�F�C�X
interface Component {
    void display();
}

// ���j���[�ꗗ
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

// ���[�j���O���j���[
class MorningMenu extends MenuList {
    public MorningMenu() {
        super("�� ���[�j���O���j���[ ��");
        add(new MenuItem("���[�j���O�Z�b�g", 400));
        add(new MenuItem("�Ă�����H", 600));
    }
}

// �����`���j���[
class LunchMenu extends MenuList {
    public LunchMenu() {
        super("�� �����`���j���[ ��");
        add(new MenuItem("���ւ�胉���`", 680));
        add(new MenuItem("�V�F�t�̂������߃����`", 890));

        // �h�����N���j���[���T�u���j���[�Ƃ��Ēǉ�
        DrinkMenu drinkMenu = new DrinkMenu();
        add(drinkMenu);
    }
}

// �f�B�i�[���j���[
class DinnerMenu extends MenuList {
    public DinnerMenu() {
        super("�� �f�B�i�[���j���[ ��");
        add(new MenuItem("�a���n���o�[�O", 680));
        add(new MenuItem("�T�[���C���X�e�[�L", 1180));

        // �h�����N���j���[���T�u���j���[�Ƃ��Ēǉ�
        DrinkMenu drinkMenu = new DrinkMenu();
        add(drinkMenu);

        // �f�U�[�g���j���[���T�u���j���[�Ƃ��Ēǉ�
        DessertMenu dessertMenu = new DessertMenu();
        add(dessertMenu);
    }
}

// �h�����N���j���[
class DrinkMenu extends MenuList {
    public DrinkMenu() {
        super("�� �h�����N���j���[ ��");
        add(new MenuItem("�R�[�q�[", 220));
        add(new MenuItem("�g��", 220));
    }
}

// �f�U�[�g���j���[
class DessertMenu extends MenuList {
    public DessertMenu() {
        super("�� �f�U�[�g���j���[ ��");
        add(new MenuItem("�`�[�Y�P�[�L", 350));
        add(new MenuItem("�A�C�X�N���[��", 150));
    }
}