public class Janken {
//        enum Result {
//            WIN,
//            LOSE,
//            DRAW,
//        }
enum Result {
    WIN("���Ȃ��̏����ł��I"),
    LOSE("���Ȃ��̕����ł��I"),
    DRAW("���������ł��I");
    public String msg; // ���s���b�Z�[�W
    Result(String msg) { this.msg = msg; } // �R���X�g���N�^
}

    enum Hand {
        GU("�O�[", "�`���L�ɏ����āA�p�[�ɕ����܂��I"), // ���O�A����
        CHOKI("�`���L", "�p�[�����āA�O�[�ɕ����܂��I"), // ���O�A����
        PA("�p�[", "�O�[�ɏ����āA�`���L�ɕ����܂��I"); // ���O�A����
        public String name; // ���O
        public String feature; // ����
        Hand(String name,String feature){
            this.name = name;
            this.feature = feature;
    }
    String getName(){
            return name;
    }
}


    public static Result[][] resultTbl = {
                {Result.DRAW,Result.WIN,Result.LOSE},
                {Result.LOSE,Result.DRAW,Result.WIN},
                {Result.WIN,Result.LOSE,Result.DRAW},
        };
}
