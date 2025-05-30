package pac24x;

// Cafeメニュー
public class CafeMenu {
    private MenuItem[] menu = new MenuItem[100];
    public CafeMenu() {
        menu[0] = new MenuItem("ドリップコーヒー", 390);
        menu[1] = new MenuItem("アールグレイ", 430);
        menu[2] = new MenuItem("オレンジジュース", 220);
        menu[3] = null;         // 終了コード
    }
    public MenuItem[] getMenu() { return menu; }
    // イテレータ


}
