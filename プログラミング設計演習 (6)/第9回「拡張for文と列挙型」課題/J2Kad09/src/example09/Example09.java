package example09;

public class Example09 {
    public static void main(String[] args) {
        Monster[] monsters = {new Monster("�s�J�`���E"),new Monster("�[�j�K��"),new Monster("�w�C�K�j")};

        //���܂ł�for��
        for (int i = 0; i < monsters.length; i++) {
            monsters[i].intro();
        }

        //�g��for��
        for (Monster m:monsters) {
            m.intro();
        }

        //�Q�����z��p�^�[��
        String[][] names ={
                {"�q�g�J�Q","�A�`����"},
                {"�t�V�M�_�l","�L����"}
        } ;

        for (int i = 0; i < names.length; i++){
            for (int j = 0; j < names[i].length; j++){
                System.out.println(names[i][j]);
            }
        }
        //�g��for��
        for (String[] name :names) {
            for (String n: name) {
                System.out.println(n);
            }
        }
    }
}
