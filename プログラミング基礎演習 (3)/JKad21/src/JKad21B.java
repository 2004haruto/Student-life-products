import java.util.Scanner;

public class JKad21B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[][] a = {{"�s�^�S���X", " �A���L���f�X ", "���[�N���b�h", " �G���g�X�e�l�X", " �t�B�{�i�b�`"},
                        {"�f�J���g", "�t�F���}�[", " �p�X�J��", " �I�C���[", " ���v���X"}};
        for (; ; ) {
            System.out.print("�K������͂��Ă��������i0�`"+(a.length-1)+"�j��");
            int c = in.nextInt();
            if ( c  <0 ){
                break;
            }
            System.out.print("�����ԍ�����͂��Ă��������i0�`"+(a[c].length-1)+"�j��");
            int d = in.nextInt();
            System.out.println(c + "�K��" + d + "�����ɂ�" +a[c][d] + "�����܂�!");
        }
    }
}




