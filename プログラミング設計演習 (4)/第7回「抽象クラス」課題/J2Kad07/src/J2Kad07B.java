
import java.util.Scanner;

public class J2Kad07B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        RPGCharacter[] characters = {new Fighter(),new Mage(),new Priest(),new Thief()};


        while(true) {
            System.out.print("ジョブを選んでください（0：戦士、1：魔法使い、2:僧侶、3:盗賊、-1：終了）＞");
            int job = in.nextInt();
            if (job < 0) break;

            if ( job >= characters.length) continue;

            characters[job].callAllMethod();

            System.out.println();
        }
    }
}
