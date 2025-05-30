/*
	課題名：J2Kad18S「MyDecorator」
	作成日：2023/11/30
	作成者：田中太郎
*/
import java.util.Scanner;

public class J2Kad18S {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("デコレーションします！");
        System.out.print("デコレーションする文字列を入力してください＞");
        StringHolder holder = new StringHolder(in.next());

        while(true) {
            System.out.print("どうしますか？（0：Star、1：Block、2：Star＋Block、-1：終了＞");
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




