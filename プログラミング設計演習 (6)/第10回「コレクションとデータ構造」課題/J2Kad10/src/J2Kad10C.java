/*
	�ۑ薼�FJ2Kad10C�u���b�p�[�N���X�v
	�쐬���F2023/10/26
	�쐬�ҁF�c�����Y
*/
import java.util.ArrayList;

public class J2Kad10C {
    public static void main(String[] args) {
        // ArrayList�̐錾
        //ArrayList<�I�u�W�F�N�g�̌^>
        //�I�u�W�F�N�g�̓N���X�̂��� int Integer
        ArrayList<Integer> arrayList = new ArrayList<>();
        // �f�[�^�̊i�[
        System.out.println("�f�[�^���i�[���܂��I");
        for (int i = 0;i < 5;i++){
            //�����̐���(0~99)
            //�I�[�g�{�N�V���O�@int �� Integer�ɕϊ����Ă���Ă���
            Integer ranNum = (int) (Math.random()*100);
            arrayList.add(ranNum);
            System.out.println("add:" + ranNum.intValue());
        }
        // �f�[�^�̕\��
        System.out.println("�f�[�^��\�����܂��I");
        //�ʏ�for��
        for (int i = 0;i < arrayList.size();i++){
            System.out.println("get:" + arrayList.get(i));
        }
        //�g��for��(Integer.ver)
        for (Integer num : arrayList){
            System.out.println("get:" + num.intValue());
        }
        //�g��for��(int.ver)
        for (int num : arrayList){
            System.out.println("get:" + num);
        }
    }
}
