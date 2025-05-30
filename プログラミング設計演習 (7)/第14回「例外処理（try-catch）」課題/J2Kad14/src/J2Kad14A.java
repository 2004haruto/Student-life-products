import java.util.Scanner;

public class J2Kad14A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] array = new int[10]; // 要素数を10に変更

        while (true) {
            try {
                System.out.print("割られる数を入力してください＞");
                String input = in.next();
                int a = Integer.parseInt(input);

                int b = (int) (Math.random() * 10); // 0から9の乱数を生成
                System.out.println(b + "で割ります!");

                if (b == 0) {
                    throw new ArithmeticException("0除算が発生しました！");
                }

                int result = a / b;
                System.out.println("計算結果は" + result + "です!");

                int index = (int) (Math.random() * 10); // 0から9の乱数を生成
                System.out.println("配列の" + index + "番目に格納します!");

                // 0から9までの乱数によって、配列のランダムな位置に結果を格納
                array[index] = result;

                System.out.println("処理が正常に行われました！");
            } catch (NumberFormatException e) {
                System.out.println("int型でない値が入力されました！");
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
                break; // 0除算の場合、ループから抜ける
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("配列に格納できません！");
            } finally {
                System.out.println("finally ブロックの処理です！");
            }
        }

        System.out.println("終了します！");
        in.close();
    }
}
