/*
	課題名：J2Kad18D「あとはよろしく！（throws）」
	作成日：2023/11/30
	作成者：田中太郎
*/
import java.io.*;
import java.util.Scanner;

public class J2Kad18D {
    public static final String FILENAME = "test.txt";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(true) {
            System.out.print("どうしますか？（0：書き出す、1：読み込む、-1：終了）＞");
            int cmd = Integer.parseInt(in.next());
            if (cmd < 0) break;

            try {
                switch (cmd) {
                    case 0:     // 書き出し
                        System.out.print("書き出す文字列を入力してください＞");
                        String str = in.next();
                        // ↓MyWriterメソッドにする
//                        BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME));
//                        bw.write(str);
//                        bw.close();
                        MyWriter(str);
                        break;
                    case 1:
                        // ↓MyReaderメソッドにする
//                        BufferedReader br = new BufferedReader(new FileReader(FILENAME));
//                        String line;
//                        while((line = br.readLine()) != null) {
//                            System.out.println(line);
//                        }
//                        br.close();
                        MyReader();
                        break;
                }
            } catch(IOException e) {
                System.out.println(e);
            }
            System.out.println();
        }
    }

    //MyWriterメソッドの作成 staticにするとnewしなくても使える
    static void MyWriter(String str) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME));
            bw.write(str);
            bw.close();
    }
    //MyReaderメソッドの作成
    static void MyReader() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(FILENAME));
        String line;
        while((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }
}
