package Example07;

public class Example07 {
    public static void main(String[] args) {
        Ito ito = new Ito("�ɓ�");
        Okuda okuda = new Okuda("���c");
        Kobayashi koba = new Kobayashi("����");
        ito.intro();
        ito.beatDrum();
        okuda.intro();
        okuda.fight();
        koba.intro();
        koba.soccer();
    }
}
