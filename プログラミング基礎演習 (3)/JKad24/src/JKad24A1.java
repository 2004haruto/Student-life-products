import java.util.Scanner;

public class JKad24A1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("��������͂��Ă��������I>");
        int n = in.nextInt();
        System.out.println(JKad24D.toBinaryString(n));

        int bit = 0;
        int count = 0;

        while(n != 0){
            if ((n & 0x01) == 1) {
                bit++;
            }
            n >>>= 1;
            count++;
        }
        System.out.println("1��" + bit + "����܂��I");
        System.out.println(count + "�񃋁[�v���܂����I");
        in.close();
    }
}
