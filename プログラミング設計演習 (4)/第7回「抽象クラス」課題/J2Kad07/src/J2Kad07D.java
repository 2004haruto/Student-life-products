/*
	課題名：J2Kad07D「ポリモーフィズムの復習」
	作成日：2023/10/17
	作成者：田中太郎
*/
import java.util.Scanner;

public class J2Kad07D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        RPGCharacter[] characters = {new Fighter(),new Mage()};


        while(true) {
            System.out.print("ジョブを選んでください（0：戦士、1：魔法使い、-1：終了）＞");
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
