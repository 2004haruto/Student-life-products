package example;

public class Example06 {
    public static void main(String[] args) {
        //���ꂼ��̃N���X����e�N���X�^�ɕύX
        Pirate luffy = new Luffy("���t�B");
        Pirate zoro = new Zoro("�]��");
        Pirate sanji = new Sanji("�T���W");
        luffy.attack();
        zoro.attack();
        sanji.attack();


    }

    public static void attack(Pirate p){
        p.attack();
        p.attack();
        p.attack();
    }

}
