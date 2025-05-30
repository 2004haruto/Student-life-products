public class Student {
    private String name;
    private String course;
    private int myNumber;
    private static int studentNumber=2230001;


    public Student(String name, String course ) {
        this.name=name;
        this.course=course;
        this.myNumber=studentNumber;
        studentNumber++;
        System.out.println(this.name+"がやってきた！");

    }

    public void showData(){
        System.out.println("名前:"+name+" コース:"+course+" 学籍番号:"+myNumber);
    }
}