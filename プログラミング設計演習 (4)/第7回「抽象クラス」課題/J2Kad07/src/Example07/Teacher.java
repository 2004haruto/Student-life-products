package Example07;

public  class Teacher {
    private String name;
    private String homeClass;
    private String field;



    public Teacher(String name,String homeClass,String field){
        this.name = name;
        this.homeClass = homeClass;
        this.field = field;
        System.out.println("ECC�R���s���[�^��"+ name+"�ł��B");
    }
    public void intro(){
        System.out.println(homeClass + "�ŒS�C���Ă܂��B,�S���Ȗڂ�" + field+"�ł��B");
    }

}
