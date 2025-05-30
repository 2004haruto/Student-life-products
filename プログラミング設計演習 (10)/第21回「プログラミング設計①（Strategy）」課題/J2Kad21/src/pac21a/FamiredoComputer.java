package pac21a;

// FamiredoComputer クラス
class FamiredoComputer {
    private FCCassette cassette;

    public void setCassette(FCCassette cassette) {
        if (cassette == null) {
            System.out.println("カセットがセットされていません！");
        } else {
            this.cassette = cassette;
            System.out.println(cassette.getTitle() + "をセットしました！");
        }
    }

    public void removeCassette() {
        if (cassette == null) {
            System.out.println("カセットがセットされていません！");
        } else {
            System.out.println(cassette.getTitle() + "を取り外しました！");
            this.cassette = null;
        }
    }

    public void play() {
        if (cassette == null) {
            System.out.println("カセットがセットされていません！");
        } else {
            cassette.execute();
        }
    }
}
