public class J2Kad15A {
    public static void main(String[] args) {
        System.out.println("ウサギとカメが競争します！");

        // ウサギとカメのインスタンス生成
        Rabbit1 rabbit = new Rabbit1();
        Turtle1 turtle = new Turtle1();

        // カメのスレッドを開始
        Thread turtleThread = new Thread(turtle);
        turtleThread.start();

        try {
            // 5秒ウェイト
            Thread.sleep(5000);

            System.out.println("5 秒後にウサギがスタート");
            // ウサギのスレッドを開始
            Thread rabbitThread = new Thread(rabbit);
            rabbitThread.start();

            // カメのスレッドが終了するまで待機
            turtleThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Rabbit1 implements Runnable {
    public Rabbit1() {
        System.out.println("ウサギがやってきた！");
    }

    @Override
    public void run() {
        System.out.println("ウサギが走ります！");
        for (int distance = 1000; distance >= 0; distance -= 10) {
            System.out.println("ウサギ：残り" + distance + "メートル！");
            try {
                Thread.sleep(10); // 10ミリ秒ウェイト
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("ウサギ：ゴールしました！");
    }
}

class Turtle1 implements Runnable {
    public Turtle1() {
        System.out.println("カメがやってきた！");
    }

    @Override
    public void run() {
        System.out.println("カメが走ります！");
        for (int distance = 1000; distance >= 0; distance -= 10) {
            System.out.println("カメ：残り" + distance + "メートル！");
            try {
                Thread.sleep(100); // 10ミリ秒ウェイト
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("カメ：ゴールしました！");
    }
}
