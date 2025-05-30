import java.io.*;

public class J2Kad17S {
    public static void main(String[] args) {
        final String FILENAME = "./out/production/J2Kad17D.class";

        try (FileInputStream fileInputStream = new FileInputStream(FILENAME);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
             DataInputStream dataInputStream = new DataInputStream(bufferedInputStream)) {

            int bytesRead;
            int byteCount = 0;

            // 1バイトずつ読み込んで表示
            while (true) {
                try {
                    bytesRead = dataInputStream.readByte();
                    System.out.print(bytesRead + " ");
                    byteCount++;

                    // 16バイトごとに改行
                    if (byteCount % 16 == 0) {
                        System.out.println();
                    }
                } catch (EOFException e) {
                    // ファイルの最後に到達したらループ終了
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
