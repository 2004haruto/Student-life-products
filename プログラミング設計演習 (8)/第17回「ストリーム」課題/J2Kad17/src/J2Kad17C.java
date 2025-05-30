import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class J2Kad17C {
    public static void main(String[] args) {
        final String FILENAME = "test.bin";

        try {
            InputStream in = new FileInputStream(FILENAME);
            int len; // 入力したデータ数
            byte[] b=new byte[1024];  // データ入力用配列
            while ((len = in.read(b)) != -1) {
                for(int i=0; i<len; i++){
                    System.out.print(b[i]+" ");
                }
            }
            in.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}