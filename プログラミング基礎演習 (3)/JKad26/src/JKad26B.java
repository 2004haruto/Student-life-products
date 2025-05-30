import java.util.Scanner;

public class JKad26B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int WIN = 0;
        final int LOSE = 1;
        final int DRAW = 2;
        String[] strHands = {"グー", "チョキ", "パー"};
        String[] strJudge = {"あなたの勝ち！", "あなたの負け！", "引き分け！"};
        String[][] table = {{"引き分け","あなたの勝ち","あなたの負け"},{"あなたの負け","引き分け","あなたの勝ち"},{"あなたの勝ち","あなたの負け","引き分け"}};
        while (true) {
            System.out.print("のび太は何を出しますか？（0：グー、1：チョキ、2：パー、-1：やめる）＞");
            int a = in.nextInt();
            if (a == -1)
                break;
            System.out.println("のび太は" + strHands[a] + "を出した!");
            int b = (int) (Math.random() * 3);
            System.out.println("しずかは" + strHands[b] + "を出した!");
            System.out.println();
            System.out.println(table[a][b]);
            System.out.println();
        }
    }
}
