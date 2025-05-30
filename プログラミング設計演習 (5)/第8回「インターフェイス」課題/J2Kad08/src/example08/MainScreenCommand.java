package example08;

public class MainScreenCommand implements Command,ExtenstionsCommand{
    @Override
    public void btnA() {
        System.out.println("UŒ‚I");
    }
    @Override
    public void btnB() {
        System.out.println("—­‚ß‹Z");
    }
    @Override
    public void btnX() {
        System.out.println("ƒWƒƒƒ“ƒvI");
    }
    @Override
    public void btnY() {
        System.out.println("‚Â‚©‚İ‹Z!");
    }

    @Override
    public void btnV() {
        System.out.println("•KE‹Z‚P");
    }

    @Override
    public void btnW() {
        System.out.println("•KE‹Z‚Q");
    }
}
