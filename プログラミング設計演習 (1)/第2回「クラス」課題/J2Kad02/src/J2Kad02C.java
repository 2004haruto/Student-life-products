/*
    �ۑ薼�FJ2Kad02C�u�����X�^�[�N���X�I�v
    �쐬���F2023/09/28
    �쐬�ҁF���ؗz�l
 */

public class J2Kad02C {
    public static void main(String[] args) {
        Monster dialga = new Monster();
        dialga.setData("�f�B�A���K",1000);
        dialga.showData();
        Monster king = new Monster();
        king.setData("�R�C�L���O",1);
        king.showData();
        System.out.println(dialga.name+"���U�������܂��I");
        dialga.walk();
        dialga.walk();
        dialga.walk();
        dialga.showData();
        System.out.println(king.name+"���U�������܂��I");
        king.walk();
        king.walk();
        king.walk();
        king.showData();
    }
}
