package pac24x;

import java.util.ArrayList;

// Burgerメニュー
public class BurgerMenu {
    private ArrayList<MenuItem> menu = new ArrayList<>();
    public BurgerMenu() {
        menu.add(new MenuItem("ハンバーガー", 150));
        menu.add(new MenuItem("チーズバーガー", 180));
        menu.add(new MenuItem("ビッグマック", 410));
    }
    public ArrayList<MenuItem> getMenu() { return menu; }
    // イテレータ


}
