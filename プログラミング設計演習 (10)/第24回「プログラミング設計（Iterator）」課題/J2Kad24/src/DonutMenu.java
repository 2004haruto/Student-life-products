// Donut���j���[
public class DonutMenu implements Menu{
    private String[] names = new String[100];
    private int[] prices = new int[100];

    public DonutMenu() {
        names[0] = "�n�j�[�f�B�b�v";
        prices[0] = 120;

        names[1] = "�n�j�[�`����";
        prices[1] = 130;

        names[2] = "�`���R�����O";
        prices[2] = 140;

        prices[3] = -1;                  // �I���R�[�h
    }
    public String[] getNames() { return names; }
    public int[] getPrices() { return prices; }

    // iterator���\�b�h
    @Override
    public MenuIterator iterator() {
        return new DonutIterator(names,prices);
    }
}
// DonutIterator
class DonutIterator implements MenuIterator{
    private String[] names;
    private int[] prices;
    private int i = 0;
    //�R���X�g���N�^
    public DonutIterator(String[] names, int[] prices){
        this.names = names;
        this.prices = prices;
    }
    public boolean hasNext(){
        return prices[i] != -1;
    }
    //MenuItem�ɂ��ĕԂ�
    public MenuItem next(){
        return new MenuItem(names[i],prices[i++]);
    }
}
