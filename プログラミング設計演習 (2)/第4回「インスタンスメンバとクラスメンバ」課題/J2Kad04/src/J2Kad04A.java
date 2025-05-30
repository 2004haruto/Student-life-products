public class J2Kad04A {
    public static void main(String[] args) {
        // インスタンスの生成
        Student nobita=new Student("のび太","IE");

        Student sizuka=new Student("しずか","SK");

        Student suneo=new Student("スネ夫","SE");

        Student jaian=new Student("ジャイアン","オレさまのコース");

        // データ表示
        System.out.println("それぞれのデータを表示します！");
        nobita.showData();
        sizuka.showData();
        suneo.showData();
        jaian.showData();
    }
}