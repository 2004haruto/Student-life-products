import java.util.Scanner;

public class JKad24A2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("��������͂��Ă���������");
        int n = in.nextInt();

        System.out.println(JKad24D.toBinaryString(n));

        int num = 0;
        int loop = 0;
        while(n != 0) {
            n = n & (n - 1);
            num++;
            loop++;
        }

        System.out.println("1��" + num + "����܂��I");
        System.out.println(loop + "�񃋁[�v���܂����I");
    }
}
