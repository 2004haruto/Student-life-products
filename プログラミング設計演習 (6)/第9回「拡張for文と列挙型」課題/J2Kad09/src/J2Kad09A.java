/*
	課題名：J2Kad09A「メゾンECC、再び！」
	作成日：2023/10/24
	作成者：田中太郎
*/
public class J2Kad09A {
    public static void main(String[] args) {
        // 住人の募集
        System.out.println("メゾンECCの住人を募集します！");
        Sheep[][] maison = new Sheep[3][];
        maison[0] = new Sheep[3];
        maison[1] = new Sheep[2];
        maison[2] = new Sheep[1];

        for (int i = 0; i < maison.length;i++){
            for (int j = 0; j < maison[i].length;j++){
                maison[i][j] = new Sheep();
            }
        }

        // 住人の自己紹介
        System.out.println("メゾンECCの住人に自己紹介させます！");
        for (Sheep[] floor : maison){
            for (Sheep s : floor){
                s.intro();
            }
            System.out.println();
        }


    }
}
