public class Tea extends HotDrink {
    public void execute() {
        boilWater();
        steepTeabag();
        pourInCup();
    }
    public void boilWater() { System.out.println("�����𕦂����܂����I"); }
    public void steepTeabag() { System.out.println("�e�B�[�o�b�O��Z���܂����I"); }
    public void pourInCup() { System.out.println("�J�b�v�ɒ����܂����I"); }

    @Override
    public void drink() {

    }
}