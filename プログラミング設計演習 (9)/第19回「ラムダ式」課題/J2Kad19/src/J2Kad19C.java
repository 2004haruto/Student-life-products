/*
	�ۑ薼�FJ2Kad19C�u�����N���X�i�����N���X�j�v
	�쐬���F2023/12/05
	�쐬�ҁF�c�����Y
*/
public class J2Kad19C {
    public static void main(String[] args) {
        //�����N���X��SayHello���쐬����
        SayHello sayHello1 = new SayHello() {
            @Override
            public void hello() {
                System.out.println("�����N���X�@�F����ɂ��́I");
            }
        };
        Greeting.greet(sayHello1);

        //�����ɃN���X��n���B���̎��ɒ��g�����B
        Greeting.greet(new SayHello() {
            public void hello() {
                System.out.println("�����N���X�@�F����ɂ��́I");
            }
        });

    }
}
