import java.util.Scanner;

public class JKad23X1 {
    public static void main(String[] args) {
        final int gu= 0;
        final int choki= 1;
        final int pa= 2;
        //手の決定
        Scanner in = new Scanner(System.in);
        int random = (int) (Math.random() * 3);
        System.out.println("じゃんけんをします！");
        System.out.print("何の手を出しますか？（0：グー、1：チョキ、2：パー）＞");
        int a = in.nextInt();
        //手の表示
        String [] strHand = {"グー","チョキ","パー"};
        System.out.println("あなたは"+strHand[a]+"を出した！");
        System.out.println("CPUは"+strHand[random]+"を出した！");
        //判定

        switch (a) {
            case gu:
                switch (random) {
                    case gu:
                        System.out.println("あいこだ！");
                        break;
                    case choki:
                        System.out.println("あなたの勝ち！");
                        break;
                    case pa:
                        System.out.println("あなたの負け！");
                        break;
                }
                break;
            case choki:
                switch (random) {
                    case gu:
                        System.out.println("あなたの負け！");
                        break;
                    case choki:
                        System.out.println("あいこだ！");
                        break;
                    case pa:
                        System.out.println("あなたの勝ち！");
                        break;
                }
                break;
            case pa:
                switch (random) {
                    case gu:
                        System.out.println("あなたの勝ち！");
                        break;
                    case choki:
                        System.out.println("あなたの負け！");
                        break;
                    case pa:
                        System.out.println("あいこだ！");
                        break;
                }
                break;
            }
    }
}
