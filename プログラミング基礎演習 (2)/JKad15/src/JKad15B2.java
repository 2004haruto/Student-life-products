import java.util.Scanner;

public class JKad15B2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("1 ���傫����������͂��Ă���������");
        int a = in.nextInt();
        System.out.println("1����"+ a + "�܂ŉ��Z���܂� !");
        int b= integrate(a);
        System.out.println("���v��" + b +"�ł�!!");
    }
    public static int integrate(int a) {
        int c;
        if (a == 1) {
            return 1;
        } else {
            c = integrate( a- 1);

        }

        return a + c;
    }
}
