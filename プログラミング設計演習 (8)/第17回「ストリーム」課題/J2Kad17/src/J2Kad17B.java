import java.io.*;

public class J2Kad17B {
    public static void main(String[] args) {
        final String SRCFILE = "test.bin";
        final String DSTFILE = "test2.bin";

        OutputStream out=null;
        InputStream in=null;

        try {
            out = new FileOutputStream(DSTFILE);
            in = new FileInputStream(SRCFILE);
            //必要な変数宣言
            int len;
            byte[] b=new byte[1024];  // データ入力用配列
            //ファイル書き込み処理(課題C参考)
            while ((len = in.read(b)) != -1) {
                //ファイル書き込み処理(課題D参考)
                out.write(b, 0, len); // 配列b のインデックス0 からlen 個のデータを出力
            }
            System.out.println("ファイルコピー完了しました！");
        } catch (IOException e) {
            System.out.println(e);
        }finally {
            //仕様② inについて開いている場合のみクローズ
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            //仕様② outについて開いている場合のみクローズ
            if(out !=null){
                try {
                    out.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}