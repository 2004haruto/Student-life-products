import java.util.Scanner;

public class JKad25C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("�p�P�����͂��Ă���������");
        String a = in.next();
        for ( int i = 0;i<a.length();i++){
            System.out.println(a.charAt(i)+"�̕����R�[�h�F0x"+Integer.toHexString(a.charAt(i)));
        }
    }
}
