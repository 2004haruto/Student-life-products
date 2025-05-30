public class J2Kad15A {
    public static void main(String[] args) {
        System.out.println("�E�T�M�ƃJ�����������܂��I");

        // �E�T�M�ƃJ���̃C���X�^���X����
        Rabbit1 rabbit = new Rabbit1();
        Turtle1 turtle = new Turtle1();

        // �J���̃X���b�h���J�n
        Thread turtleThread = new Thread(turtle);
        turtleThread.start();

        try {
            // 5�b�E�F�C�g
            Thread.sleep(5000);

            System.out.println("5 �b��ɃE�T�M���X�^�[�g");
            // �E�T�M�̃X���b�h���J�n
            Thread rabbitThread = new Thread(rabbit);
            rabbitThread.start();

            // �J���̃X���b�h���I������܂őҋ@
            turtleThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Rabbit1 implements Runnable {
    public Rabbit1() {
        System.out.println("�E�T�M������Ă����I");
    }

    @Override
    public void run() {
        System.out.println("�E�T�M������܂��I");
        for (int distance = 1000; distance >= 0; distance -= 10) {
            System.out.println("�E�T�M�F�c��" + distance + "���[�g���I");
            try {
                Thread.sleep(10); // 10�~���b�E�F�C�g
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("�E�T�M�F�S�[�����܂����I");
    }
}

class Turtle1 implements Runnable {
    public Turtle1() {
        System.out.println("�J��������Ă����I");
    }

    @Override
    public void run() {
        System.out.println("�J��������܂��I");
        for (int distance = 1000; distance >= 0; distance -= 10) {
            System.out.println("�J���F�c��" + distance + "���[�g���I");
            try {
                Thread.sleep(100); // 10�~���b�E�F�C�g
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("�J���F�S�[�����܂����I");
    }
}
