/*
	課題名：J2Kad15D「スレッド①（Threadクラス）」
	作成日：2023/11/16
	作成者：田中太郎
*/

//MyThreadクラスの作成
class MyThread extends Thread{
    public void run(){
        //super.run();
        for (int i = 0;i < 100;i++){
            System.out.println("run:"+ i);
        }
        System.out.println("run：終了しました！");
    }
}

public class J2Kad15D {
    public static void main(String[] args) {
        //スレッドの作成
        MyThread myThread = new MyThread();
        //run ではなくstart()
        myThread.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("main：" + i);
        }
        System.out.println("main：終了しました！");
    }
}
