// Cafe���j���[
public class CafeMenu implements Menu{
    private MenuItem[] menu = new MenuItem[100];
    public CafeMenu() {
        menu[0] = new MenuItem("�h���b�v�R�[�q�[", 390);
        menu[1] = new MenuItem("�A�[���O���C", 430);
        menu[2] = new MenuItem("�I�����W�W���[�X", 220);
        menu[3] = null;         // �I���R�[�h
    }
    public MenuItem[] getMenu() { return menu; }

    // iterator���\�b�h
    //�C�e���[�^�[��Ԃ��Ȃ��Ƃ����Ȃ�
    @Override
    public MenuIterator iterator() {
        return new CafeIterator(menu);
    }
}
// CafeIterator
class CafeIterator implements MenuIterator{
    private MenuItem[] menu;
    private int i = 0;

    //�R���X�g���N�^
    public CafeIterator(MenuItem[] menu){
        this.menu = menu;
    }

    //���j���[�����邩�̊m�F
    public boolean hasNext(){
        return menu[i] != null;
    }

    //�v�f��Ԃ��Ď��̔ԍ��ɂ���
    public MenuItem next(){
        return menu[i++];
    }

}
