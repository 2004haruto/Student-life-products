import java.util.Scanner;

public class JKad12A2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("�ЂƂ߂̐�������͂��Ă�������>");
        int a = in.nextInt();
        System.out.print("�ӂ��߂̐�������͂��Ă�������>");
        int b = in.nextInt();
        int c = a;
        int d = b;
        while (true){
            if(c < d) {
                c += a;
            }else if (d <c) {
                d += b;
            }else{
                System.out.println("�ŏ����{����"+d+"�ł�!");
                break;
            }
        }
    }
}
