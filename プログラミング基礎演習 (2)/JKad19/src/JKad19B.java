import java.util.Scanner;

public class JKad19B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String []a = {"�s�^�S���X","�A���L���f�X","���[�N���b�h","�G���g�X�e�l�X","�t�B�{�i�b�`"};
        while (true){
            System.out.print("�����������܂����H");
            int b = in.nextInt();
            if (0>b || b>=a.length){
                continue;
            }
            System.out.println(a[b]+"���Z��ł��܂��I");
        }
    }
}
