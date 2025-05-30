import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class J2Kad17D {
    public static void main(String[] args) {
        final String FILENAME = "test.bin";
        byte[] b = {69, 67, 67, 32, 67, 79, 77, 80};
        OutputStream out = null;
        try {
            out = new FileOutputStream(FILENAME);
            out.write(b);
            out.close();

            System.out.println(FILENAME+"にデータを出力しました！");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}