import java.util.Scanner;

public class JKad24B {
    public static void main(String[] args) {
        String[] a = {"&", "|", "~"};
        Scanner in = new Scanner(System.in);
        System.out.print("����1����͂��Ă���������");
        int n = in.nextInt();
        System.out.print("����2����͂��Ă���������");
        int n2 = in.nextInt();
        System.out.println("\t" + JKad24D.toBinaryString(n));
        System.out.println("\t" + JKad24D.toBinaryString(n2));
        System.out.print("�Ȃ�̉��Z�����܂����H(0:AND,1:OR,2~)��");
        int op = in.nextInt();
        switch (op) {
            case 0:
                System.out.println("\t" + JKad24D.toBinaryString(n));
                System.out.println("\t" + JKad24D.toBinaryString(n2));
                System.out.println("--------------------------------");
                System.out.println("\t"+JKad24D.toBinaryString(n&n2));
                break;
            case 1:
                System.out.println("\t" + JKad24D.toBinaryString(n));
                System.out.println("\t" + JKad24D.toBinaryString(n2));
                System.out.println("--------------------------------");
                System.out.println("\t"+JKad24D.toBinaryString(n|n2));
                break;
            case 2:
                System.out.println("\t" + JKad24D.toBinaryString(n));
                System.out.println("\t" + JKad24D.toBinaryString(n2));
                System.out.println("--------------------------------");
                System.out.println("\t"+JKad24D.toBinaryString(n^n2));
                break;
        }
    }
}
