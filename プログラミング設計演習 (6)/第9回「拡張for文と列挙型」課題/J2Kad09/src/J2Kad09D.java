/*
	�ۑ薼�FJ2Kad09D�uECC�����A�ĂсI�v
	�쐬���F2023/10/24
	�쐬�ҁF�c�����Y
*/
public class J2Kad09D {
    public static void main(String[] args) {
        // �Z�l�̕�W
        System.out.println("ECC�����̏Z�l���W���܂��I");
        Sheep[] nagaya = new Sheep[5];

        for (int i = 0;i < nagaya.length; i++){
            nagaya[i] = new Sheep();
       }
        //�g��for���ɕύX(�ł��Ȃ�)
//        for (Sheep s : nagaya){
//            s = new Sheep();
//        }


        System.out.println();

        // �Z�l�̎��ȏЉ�
        System.out.println("ECC�����̏Z�l�����ȏЉ�܂��I");
        //for (int i = 0;i < nagaya.length;i++){
        //    nagaya[i].intro();
        //}
        //�g��for���ɕύX
        for (Sheep s : nagaya){
            s.intro();
        }


    }
}
