/*
	�ۑ薼�FJ2Kad16B�u�X�g���[���̘A���v
	�쐬���F2023/11/21
	�쐬�ҁF�c�����Y
*/

import java.io.*;

public class J2Kad16B {
    public static void main(String[] args) {
        final String FILENAME = "test.txt";
        //File�N���X�̍쐬
        File file = new File(FILENAME);
        //�@�t�@�C�������łɂ���Ƃ��͍폜
        if (file.exists()){
            file.delete();
            System.out.println(file + "���폜���܂���!");
        }
        //�A�t�@�C���̍쐬
        try {
            if(file.createNewFile()){
                System.out.println(file + "���쐬���܂���!");
            }
        }catch (IOException e){
            System.out.println(e);
        }

        try {
            //�t�@�C�����������ނ��߂ɕK�v�Ȃ��̂�����
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);//FileWriter��n��
            PrintWriter pw = new PrintWriter(bw);//BufferedWriter��n��
            //�t�@�C���Ƀ����X�^�[�̏�����������
            System.out.println("�����X�^�[�ꗗ���쐬���܂��I");
            for (int i = 0;i <= 5;i++){
                //�����X�^�[�����
                Monster m = new Monster();
                //�t�@�C���ɏ�������
                pw.println(m.getName());
                System.out.println(m + "��ǉ�����");
            }

            pw.close();//���Ȃ��Ə������݂��I���Ȃ��ēǂݍ��݂ł��Ȃ�

            //�t�@�C�����������ނ��߂ɏ���
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);//FileWriter��A��
            //�t�@�C����ǂݍ���ł���
            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line + "��ǂݏo����!");
            }

            br.close();

        }catch (IOException e){
            System.out.println(e);
        }

    }
}
