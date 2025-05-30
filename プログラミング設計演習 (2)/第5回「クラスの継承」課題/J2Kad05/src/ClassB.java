public class ClassB extends ClassA{
    private String nameB ="クラスB!";

    public ClassB (){
        System.out.println("子クラス");
    }
    public void methodB(){
        System.out.println(super.nameA);
        System.out.println(this.nameB);
    }
}