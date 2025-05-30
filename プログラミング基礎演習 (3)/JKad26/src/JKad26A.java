import java.util.Scanner;

public class JKad26A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int kisi = 0;
        final int yumi = 1;
        final int yari = 2;
        final int syogun = 3;
        final int supai = 4;
        String[] strHands = {"騎士", "弓兵", "槍兵","将軍","スパイ"};
        String[] strJudge = {"あなたの勝ち！", "あなたの負け！", "引き分け！"};
        String[][] table = {{"引き分け","あなたの勝ち","あなたの負け","あなたの負け！","あなたの勝ち！"},{"あなたの負け","引き分け","あなたの勝ち","あなたの負け！","あなたの勝ち！"},{"あなたの勝ち","あなたの負け","引き分け","あなたの負け！","あなたの勝ち！"},{"あなたの勝ち！","あなたの勝ち！","あなたの勝ち！","あいこだ！","あなたの負け！"},{"あなたの負け！","あなたの負け！","あなたの負け！","あなたの勝ち！","あいこだ！"}};
        while (true) {
            System.out.print("のび太は何を出しますか？（0：騎士、1：弓兵、2：槍兵、3：将軍、4：スパイ、-1：やめる）＞");
            int a = in.nextInt();
            if (a == -1)
                break;
            System.out.println("のび太は" + strHands[a] + "を出した!");
            int b = (int) (Math.random() * 5);
            System.out.println("しずかは" + strHands[b] + "を出した!");
            System.out.println();
            System.out.println(table[a][b]);
            System.out.println();
        }
    }
}
