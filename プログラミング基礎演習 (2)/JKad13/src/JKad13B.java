import java.util.Scanner;

public class JKad13B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = 0;
        int b = 1;


        while (true){

            System.out.print(b+"�l�ڂ̓_������͂��Ă�������>");
            int c = in.nextInt();
            if (c < 0 && b==1) {
                System.out.println("���Ȃ��Ƃ���l���͓��͂��Ă�������!");
                continue;
            }


            if (c >=0) {
                a += c;
            }else{
                b--;
                System.out.println(b+"�l�̍��v��"+ a + "�_�ł�!");
                double d = (double) a /(double) b;
                System.out.println(b +"�l�̕��ς�" + d +"�_�ł�!");
                break;
            }
                b++;
        }
    }

}

