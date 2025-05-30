package pac21a;

// FamiredoComputer �N���X
class FamiredoComputer {
    private FCCassette cassette;

    public void setCassette(FCCassette cassette) {
        if (cassette == null) {
            System.out.println("�J�Z�b�g���Z�b�g����Ă��܂���I");
        } else {
            this.cassette = cassette;
            System.out.println(cassette.getTitle() + "���Z�b�g���܂����I");
        }
    }

    public void removeCassette() {
        if (cassette == null) {
            System.out.println("�J�Z�b�g���Z�b�g����Ă��܂���I");
        } else {
            System.out.println(cassette.getTitle() + "�����O���܂����I");
            this.cassette = null;
        }
    }

    public void play() {
        if (cassette == null) {
            System.out.println("�J�Z�b�g���Z�b�g����Ă��܂���I");
        } else {
            cassette.execute();
        }
    }
}
