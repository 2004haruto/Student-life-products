/*
	課題名：J2Kad16D「ファイル出力のきほん」
	作成日：2023/11/21
	作成者：田中太郎
*/

import javax.imageio.IIOException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class J2Kad16D {
    public static void main(String[] args) {
        final String FILENAME = "test.txt";
        final String ECCCOMP = "ECCCOMP";

        /*
            絶対パスと相対パス
            絶対パス　→　https://ecc.comp 誰から見てもわかる
            相対パス　→　今いる場所からどこにあるか
            ./ 今いる場所
            ../　一個上の場所
            ../../　二個上の場所
         */

        //Fileクラスを作成 ファイルを操作するためのクラス
        File file = new File(FILENAME);

        try {
            //ファイルの作成
            if(file.createNewFile()){
                //ファイル作成できた時の処理
                System.out.println(file + "作成しました");
            }
            FileWriter fw = new FileWriter(file);
            fw.write(ECCCOMP); //出力(書き込み)
            fw.close();
            System.out.println(file + "に" + ECCCOMP + "を書きこみました");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
