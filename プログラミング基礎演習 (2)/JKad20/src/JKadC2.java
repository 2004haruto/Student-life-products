import java.util.Scanner;

public class JKadC2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("1 ���傫����������͂��Ă���������");
        int a = in.nextInt();
        System.out.println("1����" + a + "�܂ŉ��Z���܂�!");
        int b;
        int c = 0;
        for (b = 1; b <= a; b++) {
            c+=b;
        }
        System.out.println("���v��" + c + "�ł�!");
    }
}
