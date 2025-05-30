import java.util.Scanner;

public class JKad24C {
    public static void main(String[] args) {
        String[] strOp = {"<<", ">>", "~", ">>>"};
        Scanner in = new Scanner(System.in);
        System.out.print("整数を入力してください＞");
        int n = in.nextInt();
        System.out.println("\t" + JKad24D.toBinaryString(n)); // JKad24D のtoBinaryString を使用
        while(true) {
            System.out.print("何の演算をしますか？（0：<<、1：>>、2：~、3：>>>）＞");
            int op = in.nextInt();
            if (op < 0) break; // マイナスの値で終了
            switch (op){
                case 0:
                    n=n<<1;
                    break;
                case 1:
                    n=n>>1;
                    break;
                case 2:
                    n=~n;
                    break;
                case 3:
                    n=n>>>1;
                    break;
            }
            System.out.println(strOp[op]+JKad24D.toBinaryString(n));
        }
        in.close();
    }
}
