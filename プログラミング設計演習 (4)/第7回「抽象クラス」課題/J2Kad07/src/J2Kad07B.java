
import java.util.Scanner;

public class J2Kad07B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        RPGCharacter[] characters = {new Fighter(),new Mage(),new Priest(),new Thief()};


        while(true) {
            System.out.print("�W���u��I��ł��������i0�F��m�A1�F���@�g���A2:�m���A3:�����A-1�F�I���j��");
            int job = in.nextInt();
            if (job < 0) break;

            if ( job >= characters.length) continue;

            characters[job].callAllMethod();

            System.out.println();
        }
    }
}
