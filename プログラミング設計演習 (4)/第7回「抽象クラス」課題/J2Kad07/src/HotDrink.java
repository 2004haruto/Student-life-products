public abstract class HotDrink {
    public void execute() {
        boilWater();
        drink();
        pourInCup();
        drink2();
    }
    public void boilWater() { System.out.println("�����𕦂����܂����I"); }
    public void pourInCup(){System.out.println("�J�b�v�ɒ����܂����I");}
    public  abstract void drink();
    public void drink2(){};
}