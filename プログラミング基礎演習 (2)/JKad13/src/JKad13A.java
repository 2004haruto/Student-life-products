import java.util.Scanner;

public class JKad13A {

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            System.out.println("�����ăQ�[��!");
            int a = 0;
            int b;
            int MIN = 0;
            int MAX = 99;
            int random = (int)(Math.random()*100);
            while (true){
                a++;
                do {
                    System.out.print(a + "���:" + MIN + "����" + MAX + "�܂ł̐��l����͂��Ă�������>");
                     b = in.nextInt();
                }while (b >=MAX || b <= MIN);
                if(random < b) {
                    MAX = b;
                    System.out.println(b + "��菬�����ł�!");
                }else if(random>b) {
                    MIN = b ;
                    System.out.println(b + "���傫���ł�!");
                }else if (random == b) {
                    System.out.println("�������܂���!");
                    break;
                }
            }
        }

    }
