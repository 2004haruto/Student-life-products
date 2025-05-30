import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
public class J2Kad17A {
    public static void main(String[] args) {
        final String DSTFILE = "ecc.html";
        URL url = null;
        InputStream in = null;
        OutputStream out = null;
        try {
            url = new URL("https://comp.ecc.ac.jp/");
            in = new BufferedInputStream(url.openStream());
            out = new BufferedOutputStream(new FileOutputStream(DSTFILE));

            int len;
            byte[] b = new byte[1024];
            while ((len = in.read(b)) != -1) {
                //èëÇ´çûÇ›
                out.write(b, 0, len);
            }
            System.out.println("HTMLÇéÊìæÇµÇ‹ÇµÇΩÅI");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}