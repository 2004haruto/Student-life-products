/*
	課題名：J2Kad21B「スーパーコンピュータECC1000」
	作成日：2023/12/12
	作成者：田中太郎
*/
package pac21b;

import java.util.Scanner;

public class J2Kad21B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("スーパーコンピュータECC1000を開発した！");
        System.out.println("アルゴリズムをセットすればどんな高度な計算でもできます！！");

        ECC1000 ecc1000 = new ECC1000();

        while(true) {
            System.out.print("計算アルゴリズムをセットしてください（0：Nobita、1：Suneo、2：Dekisugi、3：Sizuka、-1：終了）＞");
            int algNum = Integer.parseInt(in.next());
            if (algNum < 0) break;

            // アルゴリズムの選択


            // 演算


            System.out.println();
        }
    }
}
