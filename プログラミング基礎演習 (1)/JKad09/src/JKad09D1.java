import java.util.Scanner;

public class JKad09D1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("�ЂƂ߂̐�������͂��Ă���������");
        int a = sc.nextInt();
        System.out.print("�ӂ��߂̐�������͂��Ă���������");
        int b = sc.nextInt();
        if (a < b) {
            System.out.println("�ӂ��̐����ő傫���ق���" + b + "�ł��I");
        } else {

            System.out.println("�ӂ��̐����ő傫���ق���" + a + "�ł��I");

        }
    }
}
