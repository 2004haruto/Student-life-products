import  java.util.Scanner;

public class JKad09S {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("�̂т��̓_������͂��Ă���������");
        int a = in.nextInt();
        System.out.print("�������̓_������͂��Ă���������");
        int b = in.nextInt();
        System.out.print("�W���C�A���̓_������͂��Ă���������");
        int c = in.nextInt();
        System.out.print("�X�l�v�̓_������͂��Ă���������");
        int d = in.nextInt();
        System.out.print("�o�ؐ��̓_������͂��Ă���������");
        int e = in.nextInt();

        int f =0;

        if (a < b){
            f = a;
            a = b;
        }else{
            if (f < b){
                f = b;
            }
        }
        if (a < c){
            f = a;
            a = c;
        }else{
            if (f < c){
                f = c;
            }
        }
        if (a < d){
            f = a;
            a = d;
        }else{
            if (f < d){
                f = d;
            }
        }
        if (a < e) {
            f = a;
            a = e;
        }else{
            if (f < e){
                f = e;
            }
        }
        System.out.println("��Ԗڂɍ����̂�"+f+"�ł�");
    }
}
