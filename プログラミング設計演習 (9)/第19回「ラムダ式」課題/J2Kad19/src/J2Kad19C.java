/*
	課題名：J2Kad19C「匿名クラス（無名クラス）」
	作成日：2023/12/05
	作成者：田中太郎
*/
public class J2Kad19C {
    public static void main(String[] args) {
        //匿名クラスでSayHelloを作成する
        SayHello sayHello1 = new SayHello() {
            @Override
            public void hello() {
                System.out.println("匿名クラス①：こんにちは！");
            }
        };
        Greeting.greet(sayHello1);

        //引数にクラスを渡す。その時に中身も作る。
        Greeting.greet(new SayHello() {
            public void hello() {
                System.out.println("匿名クラス①：こんにちは！");
            }
        });

    }
}
