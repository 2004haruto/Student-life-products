public class JKad22C {
    public static void main(String[] args) {
        System.out.println("���]��ECC �̏Z�l�����ł��I");
        String[][] a = {{"�s�^�S���X", " �A���L���f�X ", "���[�N���b�h", " �G���g�X�e�l�X", " �t�B�{�i�b�`"},
                {"�f�J���g", "�t�F���}�[", " �p�X�J��", " �I�C���[", " ���v���X"},
                {"�t�[���G", "�K�E�X"}};
        for (int i = 0; i < a.length; i++) {
            System.out.print(i+"�K�̏Z�l�F");
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(j+":"+a[i][j]);
            }
            System.out.println();
        }

    }

}





