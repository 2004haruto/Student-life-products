import java.util.Scanner;

public class JKad23A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("���̐�������͂��Ă���������");
        int a = in.nextInt();
        String str = "";
        do {
            int b = a % 16;
            switch (b) {
                case 10:
                    str = 'A' + str;
                    break;
                case 11:
                    str = 'B' + str;
                    break;
                case 12:
                    str = 'C' + str;
                    break;
                case 13:
                    str = 'D' + str;
                    break;
                case 14:
                    str = 'E' + str;
                    break;
                case 15:
                    str = 'F' + str;
                    break;
                default:
                    str = b + str;
                    break;
            }
            a /= 16;
        }while (a > 0) ;


        System.out.println("16 �i���ɂ����0x" + str + "�ɂȂ�܂�!");
    }
}
