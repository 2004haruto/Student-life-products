import java.util.Scanner;

public class JKad15D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("1 ���傫������1 ����͂��Ă���������");
        int a = in.nextInt();
        System.out.print("1 ���傫������2 ����͂��Ă���������");
        int b = in.nextInt();
        System.out.println(a+"��"+b+"�̏��Ɨ]����v�Z���܂��I");
        System.out.println("�o�ؐ�����A��낵���I");
        dekisugi(a,b) ;
    }
    public static void dekisugi(int a, int b){
        System.out.println("����Ȃ̊ȒP���I");
        System.out.println("����"+a/b+"�A�]���"+a%b+"����B");
    }
}
