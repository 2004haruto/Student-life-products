import java.util.Scanner;

public class JKad12C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("1���傫����������͂��Ă�������>");
        int a = in.nextInt();
        int b = 1;
        int c  = 0;
        System.out.println("1����" + a + "�܂ŉ��Z���܂�!");
        while ( b <= a ) {
            c+=b;
            b++;
        }
        System.out.println("���v��" + c + "�ł�!!");
    }
}
