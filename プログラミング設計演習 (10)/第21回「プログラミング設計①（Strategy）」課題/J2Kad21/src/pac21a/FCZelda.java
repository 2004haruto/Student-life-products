package pac21a;

public class FCZelda implements FCCassette {
    @Override
    public String getTitle() {
        return "ゼルダ";
    }

    @Override
    public void execute() {
        System.out.println("ゼルダで遊んでいます！");
        // ゼルダのゲーム実行に関する処理を追加する
    }
}
