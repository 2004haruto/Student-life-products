import java.util.Scanner;

public class JKad13C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a ;
        int b = 0;
        int c  = 0;

        do {
            System.out.print("1 ���傫����������͂��Ă�������>");
            a=in.nextInt();

        }while ( a<=1 ) ;
         while (b<a) {
             b++;
             c += b;

         }
        System.out.println("1����"+ a + "�܂ŉ��Z���܂� !");
        System.out.println("���v��" + c + "�ł�!!");
    }
}


