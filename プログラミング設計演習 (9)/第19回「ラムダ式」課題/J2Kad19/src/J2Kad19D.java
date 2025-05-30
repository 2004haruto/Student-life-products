/*
	課題名：J2Kad19D「内部クラス」
	作成日：2023/12/05
	作成者：田中太郎
*/
// SayHelloインターフェイス


// Greetingクラス


// OuterPersonクラス


public class J2Kad19D {
    public static void main(String[] args) {
        //SayHelloインターフェースの参照を使ってOuterPersonを生成
        SayHello outer = new OuterPerson();
        //staticありのメソッドはクラス名.メソッド()で呼び出せる
        Greeting.greet(outer);

        //InnerPersonクラスを作成する(仕様はOuterPersonクラスと同じ)
        class InnerPerson implements SayHello{
            public void hello(){
                System.out.println("内部クラス：こんにちは！");
            }
        }
        SayHello inner = new InnerPerson();
        Greeting.greet(inner);
    }

}

class  Greeting{
    //SayHello型のインスタンスを引数に受け取っている
    public static void greet(SayHello s){
        s.hello();
    }
}

class OuterPerson implements SayHello{
    public void hello(){
        System.out.println("外部クラス：こんにちは！");
    }
}
