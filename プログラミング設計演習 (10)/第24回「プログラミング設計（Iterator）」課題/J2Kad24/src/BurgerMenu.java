import java.util.ArrayList;
import java.util.Iterator;

// BurgerMenu�N���X
public class BurgerMenu implements Menu {
    private ArrayList<MenuItem> menu = new ArrayList<>();

    public BurgerMenu() {
        menu.add(new MenuItem("�n���o�[�K�[", 150));
        menu.add(new MenuItem("�`�[�Y�o�[�K�[", 180));
        menu.add(new MenuItem("�r�b�O�}�b�N", 410));
    }

    public ArrayList<MenuItem> getMenu() {
        return menu;
    }

    // Iterator���\�b�h
    @Override
    public MenuIterator iterator() {
        return (MenuIterator) new BurgerIterator(menu);
    }
}

// BurgerIterator�N���X
class BurgerIterator implements Iterator<MenuItem>, MenuIterator {
    private ArrayList<MenuItem> menu;
    private int position = 0;

    public BurgerIterator(ArrayList<MenuItem> menu) {
        this.menu = menu;
    }

    @Override
    public boolean hasNext() {
        return position < menu.size();
    }

    @Override
    public MenuItem next() {
        MenuItem menuItem = menu.get(position);
        position++;
        return menuItem;
    }
}
