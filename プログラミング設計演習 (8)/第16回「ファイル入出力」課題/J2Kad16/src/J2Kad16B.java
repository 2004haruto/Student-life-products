/*
	課題名：J2Kad16B「ストリームの連結」
	作成日：2023/11/21
	作成者：田中太郎
*/

import java.io.*;

public class J2Kad16B {
    public static void main(String[] args) {
        final String FILENAME = "test.txt";
        //Fileクラスの作成
        File file = new File(FILENAME);
        //①ファイルがすでにあるときは削除
        if (file.exists()){
            file.delete();
            System.out.println(file + "を削除しました!");
        }
        //②ファイルの作成
        try {
            if(file.createNewFile()){
                System.out.println(file + "を作成しました!");
            }
        }catch (IOException e){
            System.out.println(e);
        }

        try {
            //ファイルを書き込むために必要なものを準備
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);//FileWriterを渡す
            PrintWriter pw = new PrintWriter(bw);//BufferedWriterを渡す
            //ファイルにモンスターの情報を書き込む
            System.out.println("モンスター一覧を作成します！");
            for (int i = 0;i <= 5;i++){
                //モンスターを作る
                Monster m = new Monster();
                //ファイルに書き込み
                pw.println(m.getName());
                System.out.println(m + "を追加した");
            }

            pw.close();//閉じないと書き込みが終わらなくて読み込みできない

            //ファイルを書き込むために準備
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);//FileWriterを連結
            //ファイルを読み込んでいく
            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line + "を読み出した!");
            }

            br.close();

        }catch (IOException e){
            System.out.println(e);
        }

    }
}
