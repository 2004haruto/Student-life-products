/*
	課題名：J2Kad09D「ECC長屋、再び！」
	作成日：2023/10/24
	作成者：田中太郎
*/
public class J2Kad09D {
    public static void main(String[] args) {
        // 住人の募集
        System.out.println("ECC長屋の住人を募集します！");
        Sheep[] nagaya = new Sheep[5];

        for (int i = 0;i < nagaya.length; i++){
            nagaya[i] = new Sheep();
       }
        //拡張for文に変更(できない)
//        for (Sheep s : nagaya){
//            s = new Sheep();
//        }


        System.out.println();

        // 住人の自己紹介
        System.out.println("ECC長屋の住人が自己紹介します！");
        //for (int i = 0;i < nagaya.length;i++){
        //    nagaya[i].intro();
        //}
        //拡張for文に変更
        for (Sheep s : nagaya){
            s.intro();
        }


    }
}
