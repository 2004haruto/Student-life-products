/*
	�ۑ薼�FJ2Kad07D�u�|�����[�t�B�Y���̕��K�v
	�쐬���F2023/10/17
	�쐬�ҁF�c�����Y
*/
import java.util.Scanner;

public class J2Kad07D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        RPGCharacter[] characters = {new Fighter(),new Mage()};


        while(true) {
            System.out.print("�W���u��I��ł��������i0�F��m�A1�F���@�g���A-1�F�I���j��");
            int job = in.nextInt();
            if (job < 0) break;

            if ( job >= characters.length) continue;

            characters[job].attack();
            characters[job].defend();
            characters[job].useItem();

            System.out.println();
        }
    }
}
