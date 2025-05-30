import java.util.Scanner;

public class JKad14C2 {
    public static void main(String[] args) {

        System.out.println("ジャックは豆をまいた！");
        System.out.println("次の日、天まで届く豆の木に成長した！");
        System.out.println("ここを登ればきっと宝物があるに違いない！！");
        climbBeanTree();
        System.out.println("めでたし、めでたし。");
    }
    public static void climbBeanTree() {
        Scanner in = new Scanner(System.in);
        System.out.println("ジャックは豆の木を登った！");
        System.out.print("どうしますか？（1：登る、それ以外：もう疲れた）＞");
        int a = in.nextInt();
        if ( a ==1 ) {
            climbBeanTree();
        }
        System.out.println("ジャックは豆の木を降りた！");


        }

}

