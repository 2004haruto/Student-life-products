/*
	�ۑ薼�FJ2Kad10B�u�A�z�z��iHashMap�N���X�j�v
	�쐬���F2023/10/26
	�쐬�ҁF�c�����Y
*/

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class J2Kad10B {
    public static void main(String[] args) {
        System.out.println("ECC�o�[�K�[�ւ悤�����I���j���[��\�����܂��I");
        // ���j���[�̍쐬 <key,value>
        HashMap<String,Integer> menu = new HashMap<>();
        menu.put("�n���o�[�K�[",150);
        menu.put("�`�[�Y�o�[�K�[",180);
        menu.put("�r�b�O�}�b�N",410);
        // ���j���[�̕\�� keySet()��key�̈ꗗ�����o��
        //�g��for���͗v�f�������o���č����̕ϐ��ɑ������
        for (var key : menu.keySet()){
            System.out.println(key + ":" + menu.get(key) + "�~");
        }
        //�ꉞ�O�̂��߁@Map�C���^�[�t�F�[�X�^�Ő錾����Ƃق��̃}�b�v���g�����Ƃ��ł���
        Map<String,Integer> menu2 = new HashMap<>();
        menu2 = new TreeMap<>();
    }
}
