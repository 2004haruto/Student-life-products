/*
	�ۑ薼�FJ2Kad15D�u�X���b�h�@�iThread�N���X�j�v
	�쐬���F2023/11/16
	�쐬�ҁF�c�����Y
*/

//MyThread�N���X�̍쐬
class MyThread extends Thread{
    public void run(){
        //super.run();
        for (int i = 0;i < 100;i++){
            System.out.println("run:"+ i);
        }
        System.out.println("run�F�I�����܂����I");
    }
}

public class J2Kad15D {
    public static void main(String[] args) {
        //�X���b�h�̍쐬
        MyThread myThread = new MyThread();
        //run �ł͂Ȃ�start()
        myThread.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("main�F" + i);
        }
        System.out.println("main�F�I�����܂����I");
    }
}
