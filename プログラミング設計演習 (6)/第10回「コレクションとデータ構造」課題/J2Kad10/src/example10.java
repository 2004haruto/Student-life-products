import java.util.ArrayList;

public class example10 {
    public static void main(String[] args) {
        //ArrayList<オブジェクトの型> リスト名　= new ArrayList<>();
        ArrayList<String> nameList = new ArrayList<>();
        //要素の追加 add(追加したいもの)
        nameList.add("サザエ");//インデックス[0]に追加される
        nameList.add("カツオ");//インデックス[1]に追加される
        nameList.add("マスオ");//インデックス[2]に追加される
        nameList.add(2, "タラオ"); //指定の位置に追加もできる
        // 要素の取得 get(インデックス)
        System.out.println(nameList.get(0));//サザエ
        System.out.println(nameList.get(1));//カツオ
        System.out.println(nameList.get(2));//タラオ
        System.out.println(nameList.get(3));//マスオ
        // リストの長さ lengthみたいなやつ
        System.out.println(nameList.size());
        //リストの削除 要素の指定かインデックスの指定
        //nameList.remove("カツオ");
        nameList.remove(1);//さよならカツオ
        System.out.println(nameList.get(1)); //間が削除されたら要素の移動がある

        //通常for文 lengthが使えないのでsize()を使う
        for (int i = 0; i < nameList.size(); i++) {
            System.out.println(nameList.get(i));
        }

        //拡張for文バージョン
        for (String name : nameList) {
            System.out.println(name);
        }

    }
}
