public class ClassB extends ClassA{
    private String nameB ="�N���XB!";

    public ClassB (){
        System.out.println("�q�N���X");
    }
    public void methodB(){
        System.out.println(super.nameA);
        System.out.println(this.nameB);
    }
}