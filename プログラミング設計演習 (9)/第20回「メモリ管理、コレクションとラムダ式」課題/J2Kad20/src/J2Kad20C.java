/*
	�ۑ薼�FJ2Kad20C�u�K�[�x�b�W�R���N�V�����v
	�쐬���F2023/12/07
	�쐬�ҁF�c�����Y
*/
public class J2Kad20C {
    public static void main(String[] args) {
        //�����N���X �錾���Ă���N���X�ł����g���Ȃ�
        class DataSet {
            int[] data = new int[1000];
        }
        DataSet[] dataSet = new DataSet[10000];
        //���݂̋󂫃������T�C�Y��\������
        System.out.println("���݂̃������̋󂫃T�C�Y�F" + Runtime.getRuntime().freeMemory());
        for (int i = 0;i < dataSet.length;i++) {
            dataSet[i] = new DataSet();//����
            //100��new���邲�ƂɃ������̕\��������
            if (i % 100 == 99) {
                System.out.println("�����ς݃C���X�^���X��"+ (i+1) +"���݂̃������̋󂫃T�C�Y�F" + Runtime.getRuntime().freeMemory());
            }
        }
    }
}
