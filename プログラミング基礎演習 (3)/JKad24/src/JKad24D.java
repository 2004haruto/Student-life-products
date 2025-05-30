import java.util.Scanner;

public class JKad24D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("®”‚ğ“ü—Í‚µ‚Ä‚­‚¾‚³‚¢„");
        int n = in.nextInt();
        System.out.println(toBinaryString(n));
        in.close();
    }
    public static String toBinaryString(int n) {
        String strBinary = "i" + n + "j";
        for (int i = 0; i < 32; i++) {
            strBinary = (n & 0x1) + strBinary;
            n>>=1;
        }
        return strBinary;
    }
}
