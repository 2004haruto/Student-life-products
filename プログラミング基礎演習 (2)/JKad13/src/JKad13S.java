import java.util.Scanner;

public class JKad13S {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("���͗ʎq�R���s���[�^�[ECC�g���s�J����I");
        int a;
        int i = 1;

        while (true) {
            System.out.print("�Ȃ�̒i�������Ăق����́H>");

            a = in.nextInt();

            if (9 < a) {
                System.out.println("����ȓ���́A�킩��Ȃ���I");
                continue;
            } else if (a <= 0) {
                System.out.println("����Ȃ�I");
                break;
            } else {
                for (i = 1; i <= 9; i++ ){
                    System.out.print("\t"+a * i);
                }
                System.out.println();
            }
        }
    }
}










