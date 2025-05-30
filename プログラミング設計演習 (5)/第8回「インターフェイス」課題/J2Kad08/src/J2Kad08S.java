/*
	課題名：J2Kad08S「新型エアコンの開発」
	作成日：2023/10/19
	作成者：田中太郎
*/
import java.util.Scanner;

public class J2Kad08S {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("ECCホームエレクトロニクスが新型エアコンを開発した！");

//        NewAirconクラスが完成したら、↓のコメントをはずして動作確認すること
//        IAircon ac = new NewAircon();
        while(true) {
//            ac.showData();
            System.out.print("どうしますか？（0：電源ON/OFF、1：冷房、2：暖房、3：送風、-1：終了）＞");
            int cmd = in.nextInt();
            if (cmd < 0) break;

//            switch(cmd) {
//                case 0: ac.powerOnOff();    break;
//                case 1: ac.toCool();        break;
//                case 2: ac.toHeat();        break;
//                case 3: ac.toBlow();        break;
//            }
            System.out.println();
        }
    }
}
