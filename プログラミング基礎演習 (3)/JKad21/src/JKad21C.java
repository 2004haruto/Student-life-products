import java.util.Scanner;

public class JKad21C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int [] a ={57300,25000,10000,5000,1000};
        int b ;
        for( b = 0 ; b < a.length; b++){
            System.out.println(b+1+"��:"+a[b]);
        }
        System.out.print("���Ȃ��̃X�R�A����͂��Ă���������");
        int c = in.nextInt();
        for ( b = 0 ; b < a.length ; b++){
            if ( a[b] < c){
                System.out.println(b+1+"�ʂɂȂ�܂��I");
                break;
            }else if (a[4] > c){
                System.out.println("�����L���O�O�ł��I");
                break;
            }
        }
    }
}
