import java.util.ArrayList;

public class example10 {
    public static void main(String[] args) {
        //ArrayList<�I�u�W�F�N�g�̌^> ���X�g���@= new ArrayList<>();
        ArrayList<String> nameList = new ArrayList<>();
        //�v�f�̒ǉ� add(�ǉ�����������)
        nameList.add("�T�U�G");//�C���f�b�N�X[0]�ɒǉ������
        nameList.add("�J�c�I");//�C���f�b�N�X[1]�ɒǉ������
        nameList.add("�}�X�I");//�C���f�b�N�X[2]�ɒǉ������
        nameList.add(2, "�^���I"); //�w��̈ʒu�ɒǉ����ł���
        // �v�f�̎擾 get(�C���f�b�N�X)
        System.out.println(nameList.get(0));//�T�U�G
        System.out.println(nameList.get(1));//�J�c�I
        System.out.println(nameList.get(2));//�^���I
        System.out.println(nameList.get(3));//�}�X�I
        // ���X�g�̒��� length�݂����Ȃ��
        System.out.println(nameList.size());
        //���X�g�̍폜 �v�f�̎w�肩�C���f�b�N�X�̎w��
        //nameList.remove("�J�c�I");
        nameList.remove(1);//����Ȃ�J�c�I
        System.out.println(nameList.get(1)); //�Ԃ��폜���ꂽ��v�f�̈ړ�������

        //�ʏ�for�� length���g���Ȃ��̂�size()���g��
        for (int i = 0; i < nameList.size(); i++) {
            System.out.println(nameList.get(i));
        }

        //�g��for���o�[�W����
        for (String name : nameList) {
            System.out.println(name);
        }

    }
}
