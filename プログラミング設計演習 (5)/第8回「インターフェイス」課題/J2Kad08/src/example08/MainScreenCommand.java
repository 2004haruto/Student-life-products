package example08;

public class MainScreenCommand implements Command,ExtenstionsCommand{
    @Override
    public void btnA() {
        System.out.println("�U���I");
    }
    @Override
    public void btnB() {
        System.out.println("���ߋZ");
    }
    @Override
    public void btnX() {
        System.out.println("�W�����v�I");
    }
    @Override
    public void btnY() {
        System.out.println("���݋Z!");
    }

    @Override
    public void btnV() {
        System.out.println("�K�E�Z�P");
    }

    @Override
    public void btnW() {
        System.out.println("�K�E�Z�Q");
    }
}
