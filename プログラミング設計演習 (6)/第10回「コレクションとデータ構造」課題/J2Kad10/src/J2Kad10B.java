/*
	課題名：J2Kad10B「連想配列（HashMapクラス）」
	作成日：2023/10/26
	作成者：田中太郎
*/

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class J2Kad10B {
    public static void main(String[] args) {
        System.out.println("ECCバーガーへようこそ！メニューを表示します！");
        // メニューの作成 <key,value>
        HashMap<String,Integer> menu = new HashMap<>();
        menu.put("ハンバーガー",150);
        menu.put("チーズバーガー",180);
        menu.put("ビッグマック",410);
        // メニューの表示 keySet()でkeyの一覧を取り出す
        //拡張for文は要素一つ一つを取り出して左側の変数に代入する
        for (var key : menu.keySet()){
            System.out.println(key + ":" + menu.get(key) + "円");
        }
        //一応念のため　Mapインターフェース型で宣言するとほかのマップを使うことができる
        Map<String,Integer> menu2 = new HashMap<>();
        menu2 = new TreeMap<>();
    }
}
