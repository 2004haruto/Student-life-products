/*
	課題名：J2Kad21D「ECCソフト株式会社①（委譲）」
	作成日：2023/12/12
	作成者：田中太郎
*/
import java.util.Scanner;

public class J2Kad21C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ECCSoft eccSoft = new ECCSoft();

        while(true) {
            System.out.println("どうしますか？（0：ECC ソフトに仕事を発注する、1：下請けを変更する、-1：もういい）＞");            int cmd = Integer.parseInt(in.next());
            if (cmd < 0) break;

            // ECCソフトを呼び出す
            switch (cmd){
                case 0:eccSoft.work(); break;
                case 1:
                    System.out.println("どこにしますか？（0：チューリップ商会、1：ペーパー企画、2：グローバル商事）＞");
                    int company = Integer.parseInt(in.next());
                    switch (company) {
                        case 0 -> eccSoft.setSubcontractor(new TulipCompany());
                        case 1 -> eccSoft.setSubcontractor(new PaperPlanning());
                        case 2 -> eccSoft.setSubcontractor(new GlobalTrading());
                    }
            }

            System.out.println();
        }
    }
}
