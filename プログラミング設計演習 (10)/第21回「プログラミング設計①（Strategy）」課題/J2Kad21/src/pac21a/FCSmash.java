package pac21a;

public class FCSmash implements FCCassette {
    @Override
    public String getTitle() {
        return "スマブラ";
    }

    @Override
    public void execute() {
        System.out.println("スマブラで遊んでいます！");
        // スマブラのゲーム実行に関する処理を追加する
    }
}