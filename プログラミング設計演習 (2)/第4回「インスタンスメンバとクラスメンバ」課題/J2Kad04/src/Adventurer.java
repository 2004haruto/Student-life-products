public class Adventurer {
    private static String team ;
    private String name;
    public Adventurer(String name,String team){
        this.name = name;
        Adventurer.team = team; //static�Ȃ��̂�this�ŏ����Ȃ�(�C���X�^���X�ŕ����ł��Ȃ�����)
    }
    public void show(){
        System.out.println(name+"�̏�����"+ team);  //
    }
}
