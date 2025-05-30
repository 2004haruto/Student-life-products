import java.io.*;

public class J2Kad17B {
    public static void main(String[] args) {
        final String SRCFILE = "test.bin";
        final String DSTFILE = "test2.bin";

        OutputStream out=null;
        InputStream in=null;

        try {
            out = new FileOutputStream(DSTFILE);
            in = new FileInputStream(SRCFILE);
            //�K�v�ȕϐ��錾
            int len;
            byte[] b=new byte[1024];  // �f�[�^���͗p�z��
            //�t�@�C���������ݏ���(�ۑ�C�Q�l)
            while ((len = in.read(b)) != -1) {
                //�t�@�C���������ݏ���(�ۑ�D�Q�l)
                out.write(b, 0, len); // �z��b �̃C���f�b�N�X0 ����len �̃f�[�^���o��
            }
            System.out.println("�t�@�C���R�s�[�������܂����I");
        } catch (IOException e) {
            System.out.println(e);
        }finally {
            //�d�l�A in�ɂ��ĊJ���Ă���ꍇ�̂݃N���[�Y
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            //�d�l�A out�ɂ��ĊJ���Ă���ꍇ�̂݃N���[�Y
            if(out !=null){
                try {
                    out.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}