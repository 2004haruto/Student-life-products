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
        System.out.println(this.name+"������Ă����I");

    }

    public void showData(){
        System.out.println("���O:"+name+" �R�[�X:"+course+" �w�Дԍ�:"+myNumber);
    }
}