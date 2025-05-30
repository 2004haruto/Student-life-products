import java.util.Scanner;

public class JKad12B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = 0;
        int b = 0;
        while (true){
            b++;
            System.out.print(b+"人目の点数を入力してください>");
            int c = in.nextInt();
            if (c >=0) {
                a += c;
            }else{
                b--;
                System.out.println(b+"人の合計は"+ a + "です!");
                double d = (double) a /(double) b;
                System.out.println(b +"人の平均は" + d +"です!");
                break;
                }
            }
        }

    }


