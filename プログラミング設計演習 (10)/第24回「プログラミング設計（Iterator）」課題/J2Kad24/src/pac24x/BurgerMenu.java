package pac24x;

import java.util.ArrayList;

// Burger���j���[
public class BurgerMenu {
    private ArrayList<MenuItem> menu = new ArrayList<>();
    public BurgerMenu() {
        menu.add(new MenuItem("�n���o�[�K�[", 150));
        menu.add(new MenuItem("�`�[�Y�o�[�K�[", 180));
        menu.add(new MenuItem("�r�b�O�}�b�N", 410));
    }
    public ArrayList<MenuItem> getMenu() { return menu; }
    // �C�e���[�^


}
