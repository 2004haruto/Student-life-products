/*
	�ۑ薼�FJ2Kad14S�u���グ�ނ��グ�ށE�E�E�v
	�쐬���F2023/11/14
	�쐬�ҁF�c�����Y
*/
public class J2Kad14S {
    public static void main(String[] args) {
        // �C���X�^���X�̐���
        Phrase p0 = new Phrase("���グ�� ���グ�� �������̂��肫��");
        Phrase p1 = new Phrase("��������肷������� �������傤�܂� ����炢�܂� �ӂ��炢�܂�");
        Phrase p2 = new Phrase("�����˂�Ƃ���� ���ނƂ��� ��Ԃ炱������ �Ԃ炱����");
        Phrase p3 = new Phrase("�p�C�|�p�C�| �p�C�|�̃V���[�����K��");
        Phrase p4 = new Phrase("�V���[�����K���̃O�[�����_�C");
        Phrase p5 = new Phrase("�O�[�����_�C�̃|���|�R�s�[�̃|���|�R�i�[��");
        Phrase p6 = new Phrase("���傤���イ�߂��� ���傤����");

        // �C���X�^���X�̘A��
        p0.setNext(p1).setNext(p2).setNext(p3).setNext(p4).setNext(p5).setNext(p6);

        // �\��
        Phrase p = p0;
        while (p != null) {
            System.out.println(p);              // �t���[�Y�̕\��
            p = p.getNext();                    // ���̃t���[�Y��
        }
    }
}
