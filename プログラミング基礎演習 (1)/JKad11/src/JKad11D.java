import java.util.Scanner;

public class JKad11D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("�ЂƂ߂̐�������͂��Ă�������>");
        int a = sc.nextInt();
        System.out.print("�ӂ��߂̐�������͂��Ă�������>");
        int b = sc.nextInt();
        System.out.print("1+2�̓�������͂��Ă�������>");
        int c = sc.nextInt();
        boolean correct = ( a + b ) == c;
        System.out.println("����́E�E�E" + correct);
        if ( correct ) {
            System.out.println("�����ł� !");
        }else{
            System.out.println("�s�����ł�!");

        }
    }
}
