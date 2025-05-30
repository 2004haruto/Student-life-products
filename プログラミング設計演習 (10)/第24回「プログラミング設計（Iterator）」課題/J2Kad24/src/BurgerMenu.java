import java.util.ArrayList;
import java.util.Iterator;

// BurgerMenuクラス
public class BurgerMenu implements Menu {
    private ArrayList<MenuItem> menu = new ArrayList<>();

    public BurgerMenu() {
        menu.add(new MenuItem("ハンバーガー", 150));
        menu.add(new MenuItem("チーズバーガー", 180));
        menu.add(new MenuItem("ビッグマック", 410));
    }

    public ArrayList<MenuItem> getMenu() {
        return menu;
    }

    // Iteratorメソッド
    @Override
    public MenuIterator iterator() {
        return (MenuIterator) new BurgerIterator(menu);
    }
}

// BurgerIteratorクラス
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
