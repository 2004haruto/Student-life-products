/*
	�ۑ薼�FJ2Kad18S�uMyDecorator�v
	�쐬���F2023/11/30
	�쐬�ҁF�c�����Y
*/
import java.util.Scanner;

public class J2Kad18S {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("�f�R���[�V�������܂��I");
        System.out.print("�f�R���[�V�������镶�������͂��Ă���������");
        StringHolder holder = new StringHolder(in.next());

        while(true) {
            System.out.print("�ǂ����܂����H�i0�FStar�A1�FBlock�A2�FStar�{Block�A-1�F�I����");
            int n = Integer.parseInt(in.next());
            if (n < 0) break;

            IReader reader = holder;



            System.out.println(reader.read());
        }
    }
}

interface IReader {
    String read();
}
class StringHolder implements IReader {
    private String str;
    public StringHolder(String str) { this.str = str; }
    public String read() { return str; }
}
// MyDecorator




