package pac24x;

// Cafe���j���[
public class CafeMenu {
    private MenuItem[] menu = new MenuItem[100];
    public CafeMenu() {
        menu[0] = new MenuItem("�h���b�v�R�[�q�[", 390);
        menu[1] = new MenuItem("�A�[���O���C", 430);
        menu[2] = new MenuItem("�I�����W�W���[�X", 220);
        menu[3] = null;         // �I���R�[�h
    }
    public MenuItem[] getMenu() { return menu; }
    // �C�e���[�^


}
