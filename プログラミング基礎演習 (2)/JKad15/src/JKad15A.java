import java.util.Scanner;

public class JKad15A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("ひとつめの整数を入力してください＞");
        int n1 = in.nextInt();
        System.out.print("ふたつめの整数を入力してください＞");
        int n2 = in.nextInt();
        calcGCD(n1,n2);
        calcLCM(n1,n2);
    }
    public static int calcGCD(int n1, int n2) {
        while (n1 != n2) {
            if (n1 > n2) {
                n1 -= n2;
            } else {
                n2 -= n1;
            }
        }

        System.out.println("最大公約数は" + n1 + "です！");
        return n1;
    }
    public static int calcLCM(int n1, int n2){

        int mul1 = n1;
        int mul2 = n2;

        while(mul1 != mul2) {
            if (mul1 < mul2) {
                mul1 += n1;
            } else {
                mul2 += n2;
            }
        }

        System.out.println("最小公倍数は" + mul1 + "です！");
        return mul1;
    }

}
