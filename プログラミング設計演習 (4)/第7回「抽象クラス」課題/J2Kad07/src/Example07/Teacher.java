package Example07;

public  class Teacher {
    private String name;
    private String homeClass;
    private String field;



    public Teacher(String name,String homeClass,String field){
        this.name = name;
        this.homeClass = homeClass;
        this.field = field;
        System.out.println("ECCコンピュータの"+ name+"です。");
    }
    public void intro(){
        System.out.println(homeClass + "で担任してます。,担当科目は" + field+"です。");
    }

}
