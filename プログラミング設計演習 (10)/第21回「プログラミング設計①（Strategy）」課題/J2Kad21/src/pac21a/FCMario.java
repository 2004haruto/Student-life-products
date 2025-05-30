package pac21a;

public class FCMario implements FCCassette {
    @Override
    public String getTitle() {
        return "マリオ";
    }

    @Override
    public void execute() {
        System.out.println("マリオで遊んでいます！");
        // マリオのゲーム実行に関する処理を追加する
    }
}