import java.util.Scanner;

public class JKad12A1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("�ЂƂ߂̐�������͂��Ă�������>");
        int a = in.nextInt();
        System.out.print("�ӂ��߂̐�������͂��Ă�������>");
        int b = in.nextInt();
        while (true){
            if(a>b) {
                a -= b;
            }else if (b>a){
                b -= a;
            }else{
                System.out.println("�ő���񐔂�"+a+"�ł�!");
                break;

            }
        }
    }
}
