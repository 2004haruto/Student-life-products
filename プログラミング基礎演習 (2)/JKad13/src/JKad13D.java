import java.util.Scanner;


public class JKad13D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("0 �ȏ�̐�������͂��Ă���������");
        int n = in.nextInt();
        do {
            System.out.print(n % 10);
            n /= 10;
        } while (n > 0);


        System.out.println();
        in.close();
    }
}
