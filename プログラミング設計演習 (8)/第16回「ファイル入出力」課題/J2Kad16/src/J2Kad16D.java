/*
	�ۑ薼�FJ2Kad16D�u�t�@�C���o�͂̂��ق�v
	�쐬���F2023/11/21
	�쐬�ҁF�c�����Y
*/

import javax.imageio.IIOException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class J2Kad16D {
    public static void main(String[] args) {
        final String FILENAME = "test.txt";
        final String ECCCOMP = "ECCCOMP";

        /*
            ��΃p�X�Ƒ��΃p�X
            ��΃p�X�@���@https://ecc.comp �N���猩�Ă��킩��
            ���΃p�X�@���@������ꏊ����ǂ��ɂ��邩
            ./ ������ꏊ
            ../�@���̏ꏊ
            ../../�@���̏ꏊ
         */

        //File�N���X���쐬 �t�@�C���𑀍삷�邽�߂̃N���X
        File file = new File(FILENAME);

        try {
            //�t�@�C���̍쐬
            if(file.createNewFile()){
                //�t�@�C���쐬�ł������̏���
                System.out.println(file + "�쐬���܂���");
            }
            FileWriter fw = new FileWriter(file);
            fw.write(ECCCOMP); //�o��(��������)
            fw.close();
            System.out.println(file + "��" + ECCCOMP + "���������݂܂���");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
