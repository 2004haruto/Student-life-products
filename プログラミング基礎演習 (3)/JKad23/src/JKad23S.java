import java.util.Scanner;

public class JKad23S {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("�u���v����͂��Ă�������>");
        int a = in.nextInt();
        System.out.print("�u���v����͂��Ă���������");
        int b = in.nextInt();
        int c = a % b;
        switch (c){
            case 1:
                System.out.println(a+"��"+b+"���͓��j���ł�!");
                break;
            case 2:
                System.out.println(a+"��"+b+"���͌��j���ł�!");
                break;
            case 3:
                System.out.println(a+"��"+b+"���͉Ηj���ł�!");
                break;
            case 4:
                System.out.println(a+"��"+b+"���͐��j���ł�!");
                break;
            case 5:
                System.out.println(a+"��"+b+"���͖ؗj���ł�!");
                break;
            case 6:
                System.out.println(a+"��"+b+"���͋��j���ł�!");
                break;
            case 7:
                System.out.println(a+"��"+b+"���͓y�j���ł�!");
                break;
        }
    }
}
