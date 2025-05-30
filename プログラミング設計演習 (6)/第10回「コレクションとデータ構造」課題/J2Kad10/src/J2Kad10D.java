/*
	課題名：J2Kad10D「ArrayList」
	作成日：2023/10/26
	作成者：田中太郎
*/

import java.util.ArrayList;

public class J2Kad10D {
    public static void main(String[] args) {
        // ArrayListの宣言
        //Monster [] monsters = new Monster[5];
        ArrayList<Monster> monsters = new ArrayList<>();//要素が一つもない
        // データの格納
        System.out.println("データを格納します！");
        for (int i = 0;i < 5;i++) {
            Monster m = new Monster();
            monsters.add(m);
            System.out.println("add:" + m.toString());
        }
        // データの表示
        System.out.println("データを表示します！");
        for (int i = 0;i < monsters.size();i++){
            System.out.println("get:" + monsters.get(i));
        }
        //拡張for文バージョン
        //for(配列をバラした時の型　変数名:　元の配列
        for (Monster m : monsters){
            //get(i)かできない　　名前を返してくれるやつ →toString()
            System.out.println("get:" + m.toString());

        }

    }
}
