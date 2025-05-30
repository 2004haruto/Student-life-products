/*
	課題名：J2Kad10C「ラッパークラス」
	作成日：2023/10/26
	作成者：田中太郎
*/
import java.util.ArrayList;

public class J2Kad10C {
    public static void main(String[] args) {
        // ArrayListの宣言
        //ArrayList<オブジェクトの型>
        //オブジェクトはクラスのこと int Integer
        ArrayList<Integer> arrayList = new ArrayList<>();
        // データの格納
        System.out.println("データを格納します！");
        for (int i = 0;i < 5;i++){
            //乱数の生成(0~99)
            //オートボクシング　int → Integerに変換してくれている
            Integer ranNum = (int) (Math.random()*100);
            arrayList.add(ranNum);
            System.out.println("add:" + ranNum.intValue());
        }
        // データの表示
        System.out.println("データを表示します！");
        //通常for文
        for (int i = 0;i < arrayList.size();i++){
            System.out.println("get:" + arrayList.get(i));
        }
        //拡張for文(Integer.ver)
        for (Integer num : arrayList){
            System.out.println("get:" + num.intValue());
        }
        //拡張for文(int.ver)
        for (int num : arrayList){
            System.out.println("get:" + num);
        }
    }
}
