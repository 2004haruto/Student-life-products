import java.util.Scanner;

public class JKad12B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = 0;
        int b = 0;
        while (true){
            b++;
            System.out.print(b+"�l�ڂ̓_������͂��Ă�������>");
            int c = in.nextInt();
            if (c >=0) {
                a += c;
            }else{
                b--;
                System.out.println(b+"�l�̍��v��"+ a + "�ł�!");
                double d = (double) a /(double) b;
                System.out.println(b +"�l�̕��ς�" + d +"�ł�!");
                break;
                }
            }
        }

    }


