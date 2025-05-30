import java.util.Scanner;

public class JKad19B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String []a = {"ピタゴラス","アルキメデス","ユークリッド","エラトステネス","フィボナッチ"};
        while (true){
            System.out.print("何号室を見ますか？");
            int b = in.nextInt();
            if (0>b || b>=a.length){
                continue;
            }
            System.out.println(a[b]+"が住んでいます！");
        }
    }
}
