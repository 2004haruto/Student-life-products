import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class J2Kad16A {
    public static void main(String[] args) {
        final String PATHNAME = "./data/";
        Scanner in = new Scanner(System.in);

        // フォルダの一覧を配列に入れる
        File folder = new File(PATHNAME);
        String[] filelist = folder.list();

        while (true) {
            // フォルダ内のファイル一覧を表示
            for (int i = 0; i < filelist.length; i++) {
                System.out.print(filelist[i] + "\t");
                if (i % 10 == 9) System.out.println();
            }

            System.out.print("\nどのドットパターンを見ますか？（拡張子不要、-1：終了）＞");
            String name = in.next();

            if (name.equals("-1")) {
                // 終了
                break;
            }

            // ファイルが存在するか確認
            String filename = name + ".txt";
            File file = new File(PATHNAME + filename);

            if (!file.exists()) {
                System.out.println("そのデータは存在しません！");
                continue;
            }

            // ファイルの中身を表示
            try (FileReader reader = new FileReader(file)) {
                int c;
                while ((c = reader.read()) != -1) {
                    System.out.print((char) c);
                }
                System.out.println(); // 改行
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
