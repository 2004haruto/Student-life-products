import java.util.Scanner;

public class JKad23S {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("「月」を入力してください>");
        int a = in.nextInt();
        System.out.print("「日」を入力してください＞");
        int b = in.nextInt();
        int c = a % b;
        switch (c){
            case 1:
                System.out.println(a+"月"+b+"日は日曜日です!");
                break;
            case 2:
                System.out.println(a+"月"+b+"日は月曜日です!");
                break;
            case 3:
                System.out.println(a+"月"+b+"日は火曜日です!");
                break;
            case 4:
                System.out.println(a+"月"+b+"日は水曜日です!");
                break;
            case 5:
                System.out.println(a+"月"+b+"日は木曜日です!");
                break;
            case 6:
                System.out.println(a+"月"+b+"日は金曜日です!");
                break;
            case 7:
                System.out.println(a+"月"+b+"日は土曜日です!");
                break;
        }
    }
}
