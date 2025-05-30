public class Adventurer {
    private static String team ;
    private String name;
    public Adventurer(String name,String team){
        this.name = name;
        Adventurer.team = team; //staticなものはthisで書けない(インスタンスで複製できないため)
    }
    public void show(){
        System.out.println(name+"の所属は"+ team);  //
    }
}
