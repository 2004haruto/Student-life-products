package pac23x;

import java.util.ArrayList;

public class CafeMenu {
    private ArrayList<MenuItem> menu = new ArrayList<>();
    public CafeMenu() {
        menu.add(new MenuItem("ドリップコーヒー", 390));
        menu.add(new MenuItem("アールグレイ", 430));
        menu.add(new MenuItem("オレンジジュース", 220));
    }
    public ArrayList<MenuItem> getMenu() { return menu; }
}