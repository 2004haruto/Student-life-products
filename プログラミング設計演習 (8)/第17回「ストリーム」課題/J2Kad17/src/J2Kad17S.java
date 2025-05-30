import java.io.*;

public class J2Kad17S {
    public static void main(String[] args) {
        final String FILENAME = "./out/production/J2Kad17D.class";

        try (FileInputStream fileInputStream = new FileInputStream(FILENAME);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
             DataInputStream dataInputStream = new DataInputStream(bufferedInputStream)) {

            int bytesRead;
            int byteCount = 0;

            // 1�o�C�g���ǂݍ���ŕ\��
            while (true) {
                try {
                    bytesRead = dataInputStream.readByte();
                    System.out.print(bytesRead + " ");
                    byteCount++;

                    // 16�o�C�g���Ƃɉ��s
                    if (byteCount % 16 == 0) {
                        System.out.println();
                    }
                } catch (EOFException e) {
                    // �t�@�C���̍Ō�ɓ��B�����烋�[�v�I��
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
