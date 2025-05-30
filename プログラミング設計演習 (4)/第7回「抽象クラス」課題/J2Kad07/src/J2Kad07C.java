
import java.util.Scanner;

public class J2Kad07C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        RPGCharacter[] characters = {new Fighter(),new Mage(),new Priest()};


        while(true) {
            System.out.print("�W���u��I��ł��������i0�F��m�A1�F���@�g���A2:�m���A-1�F�I���j��");
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
