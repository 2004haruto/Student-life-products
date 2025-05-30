package pac21s;

public class RPGCharacter {
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
    private static int rest = nameData.length;
    private String name;

    public RPGCharacter() {
        int n = (int)(Math.random() * rest);
        name = nameData[n];
        nameData[n] = nameData[--rest];
        nameData[rest] = name;
        if (rest == 0) rest = nameData.length;
    }
    public String toString() { return name; }
    public void attack() { System.out.println("�U�����@��m��Ȃ��I"); }
    public void defend() { System.out.println("�h����@��m��Ȃ��I"); }
}
// �E�ƃN���X
class Fighter extends RPGCharacter {
    public void attack() { System.out.println("����ōU�����܂��I"); }
    public void defend() { System.out.println("���Ŗh�䂵�܂��I"); }
}
class Mage extends RPGCharacter {
    public void attack() { System.out.println("�U���̖��@�������܂��I"); }
    public void defend() { System.out.println("�h��̖��@�������܂��I"); }
}
class Monk extends RPGCharacter {
    public void attack() { System.out.println("�f��Ő킢�܂��I"); }
    public void defend() { System.out.println("�f��Ŏ��܂��I"); }
}
