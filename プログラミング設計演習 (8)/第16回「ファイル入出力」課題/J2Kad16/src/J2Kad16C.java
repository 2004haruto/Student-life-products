/*
	課題名：J2Kad16C「ファイル入力のきほん」
	作成日：2023/11/21
	作成者：田中太郎
*/

import javax.imageio.IIOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class J2Kad16C {
    public static void main(String[] args) {
        final String FILENAME = "test.txt";

        //Fileクラスの作成
        File file = new File(FILENAME);
        System.out.println(file + "から文字列を読み出します!");
        //ファイルの読み込む処理
        try {
            FileReader fr = new FileReader(file);
            int data;//読み込んだ文字を入れる変数
            while ((data = fr.read()) != -1) {
                //文字コードから文字に変換
                System.out.println(data + "を読み出しました!");
            }
            //ファイルを閉じる
            fr.close();
        }catch (IOException e){
            System.out.println(e);
        }
    }
}
