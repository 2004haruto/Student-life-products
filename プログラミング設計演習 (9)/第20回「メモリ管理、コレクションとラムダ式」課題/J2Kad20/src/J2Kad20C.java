/*
	課題名：J2Kad20C「ガーベッジコレクション」
	作成日：2023/12/07
	作成者：田中太郎
*/
public class J2Kad20C {
    public static void main(String[] args) {
        //内部クラス 宣言しているクラスでしか使えない
        class DataSet {
            int[] data = new int[1000];
        }
        DataSet[] dataSet = new DataSet[10000];
        //現在の空きメモリサイズを表示する
        System.out.println("現在のメモリの空きサイズ：" + Runtime.getRuntime().freeMemory());
        for (int i = 0;i < dataSet.length;i++) {
            dataSet[i] = new DataSet();//生成
            //100回newするごとにメモリの表示をする
            if (i % 100 == 99) {
                System.out.println("生成済みインスタンス数"+ (i+1) +"現在のメモリの空きサイズ：" + Runtime.getRuntime().freeMemory());
            }
        }
    }
}
