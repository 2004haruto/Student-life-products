package pac23x;

public class DonutMenu {
    private String[] names = new String[100];
    private int[] prices = new int[100];

    public DonutMenu() {
        names[0] = "ハニーディップ";
        prices[0] = 120;

        names[1] = "ハニーチュロ";
        prices[1] = 130;

        names[2] = "チョコリング";
        prices[2] = 140;

        prices[3] = -1;                  // 終了コード
    }
    public String[] getNames() { return names; }
    public int[] getPrices() { return prices; }
}
