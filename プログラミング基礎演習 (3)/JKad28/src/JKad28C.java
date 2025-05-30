public class JKad28C {
    public static void main(String[] args) {
        int[] array = new int[20];
        JKad28D.initArray(array);
        JKad28D.showArray(array);
        selectionSort(array, 0); // �I���\�[�g�i0 �Ԗڂ���Ō���܂Łj
        selectionSort(array, 1); // �I���\�[�g�i1 �Ԗڂ���Ō���܂Łj
        selectionSort(array, 2); // �I���\�[�g�i2 �Ԗڂ���Ō���܂Łj
        JKad28D.showArray(array);
    }
    public static void selectionSort(int[] array, int start) {
        int min = start; // ��ԏ������l�̃C���f�b�N�X
        int minValue = array[start]; //��ԏ������l��ێ�����

        //��ԏ������l��T��
        for (int i = start+1; i < array.length; i++) {
            // �l��������������ʒu��ύX����
            if (array[i] < minValue){
                min = i;
                minValue = array[i];
            }
        }

        JKad28D.showArray(array, start, min, array.length); // start �Ԗڂ���Ō���܂ŕ\��
        System.out.println();

        //start �Ԗڂ�min �Ԗڂ̓���ւ�
        int num = array[start];
        array[start] = array[min];
        array[min] = num;
    }
}