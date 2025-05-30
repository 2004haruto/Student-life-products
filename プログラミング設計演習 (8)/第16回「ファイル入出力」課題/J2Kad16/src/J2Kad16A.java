import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class J2Kad16A {
    public static void main(String[] args) {
        final String PATHNAME = "./data/";
        Scanner in = new Scanner(System.in);

        // �t�H���_�̈ꗗ��z��ɓ����
        File folder = new File(PATHNAME);
        String[] filelist = folder.list();

        while (true) {
            // �t�H���_���̃t�@�C���ꗗ��\��
            for (int i = 0; i < filelist.length; i++) {
                System.out.print(filelist[i] + "\t");
                if (i % 10 == 9) System.out.println();
            }

            System.out.print("\n�ǂ̃h�b�g�p�^�[�������܂����H�i�g���q�s�v�A-1�F�I���j��");
            String name = in.next();

            if (name.equals("-1")) {
                // �I��
                break;
            }

            // �t�@�C�������݂��邩�m�F
            String filename = name + ".txt";
            File file = new File(PATHNAME + filename);

            if (!file.exists()) {
                System.out.println("���̃f�[�^�͑��݂��܂���I");
                continue;
            }

            // �t�@�C���̒��g��\��
            try (FileReader reader = new FileReader(file)) {
                int c;
                while ((c = reader.read()) != -1) {
                    System.out.print((char) c);
                }
                System.out.println(); // ���s
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
