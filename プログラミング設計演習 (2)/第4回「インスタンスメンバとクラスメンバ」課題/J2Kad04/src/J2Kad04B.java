/*
    課題名：J2Kad04B「インスタンスの配列」
    作成日：2023/10/05
    作成者：正木陽斗
 */
public class J2Kad04B {
    public static void main(String[] args) {
        Sheep.countSheep();
        Sheep[] sheeps = new Sheep[3];
        for (int i = 0; i < sheeps.length; i++){
            sheeps[i] = new Sheep();
        }
        Sheep.countSheep();
        for (int i = 0; i < sheeps.length; i++){
            sheeps[i].intro();
        }
    }
}
