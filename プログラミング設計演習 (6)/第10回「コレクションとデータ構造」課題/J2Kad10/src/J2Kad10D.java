/*
	�ۑ薼�FJ2Kad10D�uArrayList�v
	�쐬���F2023/10/26
	�쐬�ҁF�c�����Y
*/

import java.util.ArrayList;

public class J2Kad10D {
    public static void main(String[] args) {
        // ArrayList�̐錾
        //Monster [] monsters = new Monster[5];
        ArrayList<Monster> monsters = new ArrayList<>();//�v�f������Ȃ�
        // �f�[�^�̊i�[
        System.out.println("�f�[�^���i�[���܂��I");
        for (int i = 0;i < 5;i++) {
            Monster m = new Monster();
            monsters.add(m);
            System.out.println("add:" + m.toString());
        }
        // �f�[�^�̕\��
        System.out.println("�f�[�^��\�����܂��I");
        for (int i = 0;i < monsters.size();i++){
            System.out.println("get:" + monsters.get(i));
        }
        //�g��for���o�[�W����
        //for(�z����o���������̌^�@�ϐ���:�@���̔z��
        for (Monster m : monsters){
            //get(i)���ł��Ȃ��@�@���O��Ԃ��Ă������ ��toString()
            System.out.println("get:" + m.toString());

        }

    }
}
