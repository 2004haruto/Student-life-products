/*
	課題名：J2Kad18C「例外を投げよう！（throw）」
	作成日：2023/11/30
	作成者：田中太郎
*/
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class J2Kad18C {
    public static void main(String[] args) {
        System.out.println("例外をスローしてキャッチします！");
        while(true) {
            try {
               throwException();
            }catch (IOException e) {
                    //ざっくりIOException

                System.out.println(e + "をキャッチしました！");


            } catch (Exception e) {
                System.out.println(e + "をキャッチしました！");
                System.out.println("終了します！");
                break;
            }
            System.out.println();
        }
    }

    static void throwException() throws IOException{
        Scanner in = new Scanner(System.in);
        System.out.print("どの例外をスローしますか？（0:FileNotFoundException、1:EOFException）＞");
        int n = Integer.parseInt(in.next());
        //0の時　FileNotFoundException　を発生させる
        //1の時　EOFException を発生させる

            switch (n) {
                case 0:
                    throw new FileNotFoundException();
                case 1:
                    throw new EOFException();
            }
    }
}
