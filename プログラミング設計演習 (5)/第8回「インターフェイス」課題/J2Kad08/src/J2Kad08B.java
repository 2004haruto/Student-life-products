/*
	�ۑ薼�FJ2Kad08B�u�����I�d�b�̂ł���J�����I�I�v
	�쐬���F2023/10/19
	�쐬�ҁF�c�����Y
*/
import java.util.Scanner;

public class J2Kad08B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // ��CameraPhone���쐬������R�����g���͂�������
        CameraPhone cp = new CameraPhone();     // �S��
        ICamera c = cp;                         // �J�����@�\
        IPhone p = cp;                          // �d�b�@�\

        while (true) {
            System.out.print("�ǂ̋@�\���g���܂����H�i0�F�S���A1�F�J�����A2�F�d�b�A-1�F�����������j��");
            int n = in.nextInt();
            if (n < 0) break;

            // �쐬���邱��
            switch (n){
                default: break;
                case 0:
                    cp.takePicture();
                    cp.displayImage();
                    cp.call();
                    cp.getApp();
                    break;
                case 1:
                    c.takePicture();
                    c.displayImage();
                    break;
                case 2:
                    p.call();
            }

            System.out.println();
        }
        in.close();
    }
}
