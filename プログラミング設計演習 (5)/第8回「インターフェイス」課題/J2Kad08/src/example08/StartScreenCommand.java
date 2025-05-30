package example08;

public class StartScreenCommand implements Command,ExtenstionsCommand{
    @Override
    public void btnA() {
        System.out.println("メイン画面に移動");
    }
    @Override
    public void btnB() {
        System.out.println("メイン画面に移動");
    }
    @Override
    public void btnX() {
        System.out.println("メイン画面に移動");
    }
    @Override
    public void btnY() {
        System.out.println("メイン画面に移動");
    }

    @Override
    public void btnV() {
        System.out.println("メイン画面に移動");
    }
    @Override
    public void btnW() {
        System.out.println("メイン画面に移動");
    }
}
