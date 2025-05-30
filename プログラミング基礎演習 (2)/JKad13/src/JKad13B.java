import java.util.Scanner;

public class JKad13B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = 0;
        int b = 1;


        while (true){

            System.out.print(b+"人目の点数を入力してください>");
            int c = in.nextInt();
            if (c < 0 && b==1) {
                System.out.println("少なくとも一人分は入力してください!");
                continue;
            }


            if (c >=0) {
                a += c;
            }else{
                b--;
                System.out.println(b+"人の合計は"+ a + "点です!");
                double d = (double) a /(double) b;
                System.out.println(b +"人の平均は" + d +"点です!");
                break;
            }
                b++;
        }
    }

}

