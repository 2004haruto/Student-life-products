/*
	�ۑ薼�FJ2Kad09A�u���]��ECC�A�ĂсI�v
	�쐬���F2023/10/24
	�쐬�ҁF�c�����Y
*/
public class J2Kad09A {
    public static void main(String[] args) {
        // �Z�l�̕�W
        System.out.println("���]��ECC�̏Z�l���W���܂��I");
        Sheep[][] maison = new Sheep[3][];
        maison[0] = new Sheep[3];
        maison[1] = new Sheep[2];
        maison[2] = new Sheep[1];

        for (int i = 0; i < maison.length;i++){
            for (int j = 0; j < maison[i].length;j++){
                maison[i][j] = new Sheep();
            }
        }

        // �Z�l�̎��ȏЉ�
        System.out.println("���]��ECC�̏Z�l�Ɏ��ȏЉ���܂��I");
        for (Sheep[] floor : maison){
            for (Sheep s : floor){
                s.intro();
            }
            System.out.println();
        }


    }
}
