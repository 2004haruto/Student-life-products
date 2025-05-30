// Cafeメニュー
public class CafeMenu implements Menu{
    private MenuItem[] menu = new MenuItem[100];
    public CafeMenu() {
        menu[0] = new MenuItem("ドリップコーヒー", 390);
        menu[1] = new MenuItem("アールグレイ", 430);
        menu[2] = new MenuItem("オレンジジュース", 220);
        menu[3] = null;         // 終了コード
    }
    public MenuItem[] getMenu() { return menu; }

    // iteratorメソッド
    //イテレーターを返さないといけない
    @Override
    public MenuIterator iterator() {
        return new CafeIterator(menu);
    }
}
// CafeIterator
class CafeIterator implements MenuIterator{
    private MenuItem[] menu;
    private int i = 0;

    //コンストラクタ
    public CafeIterator(MenuItem[] menu){
        this.menu = menu;
    }

    //メニューがあるかの確認
    public boolean hasNext(){
        return menu[i] != null;
    }

    //要素を返して次の番号にする
    public MenuItem next(){
        return menu[i++];
    }

}
