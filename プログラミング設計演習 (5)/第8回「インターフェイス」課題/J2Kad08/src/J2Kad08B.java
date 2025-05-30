/*
	課題名：J2Kad08B「発明！電話のできるカメラ！！」
	作成日：2023/10/19
	作成者：田中太郎
*/
import java.util.Scanner;

public class J2Kad08B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // ↓CameraPhoneを作成したらコメントをはずすこと
        CameraPhone cp = new CameraPhone();     // 全部
        ICamera c = cp;                         // カメラ機能
        IPhone p = cp;                          // 電話機能

        while (true) {
            System.out.print("どの機能を使いますか？（0：全部、1：カメラ、2：電話、-1：もうあきた）＞");
            int n = in.nextInt();
            if (n < 0) break;

            // 作成すること
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
