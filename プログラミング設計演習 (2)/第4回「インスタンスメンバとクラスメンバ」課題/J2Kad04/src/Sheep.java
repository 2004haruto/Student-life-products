public class Sheep {
    private static int n = 0;
    private static String[] nameData = {
            "�s�^�S���X",
            "�A���L���f�X",
            "�G���X�g�e�l�X",
            "���[�N���b�h",
            "�t�B�{�i�b�`",
            "�f�J���g",
            "�t�F���}�[",
            "�p�X�J��",
            "�I�C���[",
            "���v���X",
            "�t�[���G",
            "�K�E�X",
            "�h�E�����K��",
            "�u�[��",
            "���[�}��",
            "�|�A���J��",
            "���b�Z��",
            "�j���[�g��",
            "�e�C���[",

            "�P�v���[",
            "�K�����I",
            "�{�C��",
            "�t�b�N",
            "�z�C�w���X",
            "�x���k�C",
            "���O�����W��",
            "�t�@���f�[",
            "�W���[��",
            "�t�[�R�[",
            "�X�g�[�N�X",
            "�}�N�X�E�F��",
            "�}�b�n",
            "�����g�Q��",
            "�L�����[",
            "���U�t�H�[�h",
            "�A�C���V���^�C��",
    };
    private String name;

    public static void countSheep(){
        System.out.println("�r�͑S����"+n+"�C�ł��I");
    }

    public Sheep() {
        name = nameData[(int)(Math.random() * nameData.length)];
        System.out.println(name + "������Ă����I");
        n++;
    }
    public void intro() {
        System.out.println("�u�킽����" + name + "�A��낵�����F�`�I�v");
    }
}
