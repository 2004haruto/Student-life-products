/*
	課題名：J2Kad19B「ラムダ式」
	作成日：2023/12/05
	作成者：田中太郎
*/
public class J2Kad19B {
    public static void main(String[] args) {
        //匿名クラスでSayHelloを作成する
        SayHello sayHello1 = new SayHello() {
            @Override
            public void hello() {
                System.out.println("匿名クラス①：こんにちは！");
            }
        };
        Greeting.greet(sayHello1);

        //上のやつをラムダ式にする
        SayHello lambdaSayHello1 = () -> {System.out.println("ラムダ式①：こんにちは！");};
        Greeting.greet(lambdaSayHello1);

        //引数にクラスを渡す。その時に中身も作る。
        Greeting.greet(new SayHello() {
            public void hello() {
                System.out.println("匿名クラス①：こんにちは！");
            }
        });

        //上のやつをラムダ式にする
        Greeting.greet(() -> System.out.println("ラムダ式②：こんにちは！"));
    }
}
