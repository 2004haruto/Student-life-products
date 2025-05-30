import java.util.Scanner;

public class JKad13X {
    static boolean isBuzzBool;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("いくつまで叫びますか？＞");
        int a = in.nextInt();

        if(a < 1) {
            System.out.println("叫べません！");
            return;
        }
        for(int i = 1; i <= a; i++){

            if(isBuzz(i) && isFizz(i)){
                System.out.print("わにゃん！\n");
            }else if(isBuzzBool){
                System.out.print("にゃん！\n");
            }else if(isFizz(i)){
                System.out.print("わん！\n");
            }else{
                System.out.println(i);
            }

        }
    }
    public static boolean isBuzz(int i) {
        isBuzzBool = (i % 5) == 0;
        return isBuzzBool;
    }
    public static boolean isFizz(int i){
        if (i % 3 == 0) return true;
        while(i > 1) {

            if (i % 10 == 3) return true;

            i /= 10;
        }
        return false;
    }
}
