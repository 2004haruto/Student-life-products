import java.util.Scanner;

public class UserPlayer extends BasePlayer {
    private Scanner in = new Scanner(System.in);

    public UserPlayer() {
        System.out.print("あなたの名前を入力してください＞");
        name = in.next();
    }
    public int takeStone(int stone) {
        System.out.print("何個取りますか？（1-3）＞");
        return in.nextInt();
    }
    protected String myStrategy() { return "あなたが操作するプレイヤーです。"; }
}
