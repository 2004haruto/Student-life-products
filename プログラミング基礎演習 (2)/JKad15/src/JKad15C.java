import java.util.Scanner;

public class JKad15C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("1 ���傫������1 ����͂��Ă���������");
        int a = in.nextInt();
        System.out.print("1 ���傫������2 ����͂��Ă���������");
        int b = in.nextInt();
        System.out.println(a+"��"+b+"�̏��Ɨ]����v�Z���܂��I");
        System.out.print("�N���Ăяo���܂����H�i1�F�o�ؐ��A����ȊO�F�̂ё��j��");
        int c = in.nextInt();
        if ( c==1 ){
            dekisugi(a,b) ;
        }else{
            nobita(a,b);
        }

    }
    public static void dekisugi(int a, int b){
        System.out.println("����Ȃ̊ȒP���I");
        System.out.println("����"+a/b+"�A�]���"+a%b+"����B");
    }
    public static void nobita(int a, int b){
        System.out.println("���A�������I�����S��H�ׂ���ƈꏏ���ˁI");
        int d = 0;
        while(a >= b) {
            a -= b;
        }
            System.out.println("����"+b+"�A�]���"+a+"����B");

    }
}
