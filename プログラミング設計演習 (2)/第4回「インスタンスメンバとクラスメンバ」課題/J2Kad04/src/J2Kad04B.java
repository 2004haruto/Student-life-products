/*
    �ۑ薼�FJ2Kad04B�u�C���X�^���X�̔z��v
    �쐬���F2023/10/05
    �쐬�ҁF���ؗz�l
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
