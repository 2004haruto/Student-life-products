import java.util.Scanner;

public class JKad24C {
    public static void main(String[] args) {
        String[] strOp = {"<<", ">>", "~", ">>>"};
        Scanner in = new Scanner(System.in);
        System.out.print("��������͂��Ă���������");
        int n = in.nextInt();
        System.out.println("\t" + JKad24D.toBinaryString(n)); // JKad24D ��toBinaryString ���g�p
        while(true) {
            System.out.print("���̉��Z�����܂����H�i0�F<<�A1�F>>�A2�F~�A3�F>>>�j��");
            int op = in.nextInt();
            if (op < 0) break; // �}�C�i�X�̒l�ŏI��
            switch (op){
                case 0:
                    n=n<<1;
                    break;
                case 1:
                    n=n>>1;
                    break;
                case 2:
                    n=~n;
                    break;
                case 3:
                    n=n>>>1;
                    break;
            }
            System.out.println(strOp[op]+JKad24D.toBinaryString(n));
        }
        in.close();
    }
}
