/*
	�ۑ薼�FJ2Kad19B�u�����_���v
	�쐬���F2023/12/05
	�쐬�ҁF�c�����Y
*/
public class J2Kad19B {
    public static void main(String[] args) {
        //�����N���X��SayHello���쐬����
        SayHello sayHello1 = new SayHello() {
            @Override
            public void hello() {
                System.out.println("�����N���X�@�F����ɂ��́I");
            }
        };
        Greeting.greet(sayHello1);

        //��̂�������_���ɂ���
        SayHello lambdaSayHello1 = () -> {System.out.println("�����_���@�F����ɂ��́I");};
        Greeting.greet(lambdaSayHello1);

        //�����ɃN���X��n���B���̎��ɒ��g�����B
        Greeting.greet(new SayHello() {
            public void hello() {
                System.out.println("�����N���X�@�F����ɂ��́I");
            }
        });

        //��̂�������_���ɂ���
        Greeting.greet(() -> System.out.println("�����_���A�F����ɂ��́I"));
    }
}
