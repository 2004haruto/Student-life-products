/*
	�ۑ薼�FJ2Kad16C�u�t�@�C�����͂̂��ق�v
	�쐬���F2023/11/21
	�쐬�ҁF�c�����Y
*/

import javax.imageio.IIOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class J2Kad16C {
    public static void main(String[] args) {
        final String FILENAME = "test.txt";

        //File�N���X�̍쐬
        File file = new File(FILENAME);
        System.out.println(file + "���當�����ǂݏo���܂�!");
        //�t�@�C���̓ǂݍ��ޏ���
        try {
            FileReader fr = new FileReader(file);
            int data;//�ǂݍ��񂾕���������ϐ�
            while ((data = fr.read()) != -1) {
                //�����R�[�h���當���ɕϊ�
                System.out.println(data + "��ǂݏo���܂���!");
            }
            //�t�@�C�������
            fr.close();
        }catch (IOException e){
            System.out.println(e);
        }
    }
}
