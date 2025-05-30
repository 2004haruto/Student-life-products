//import java.util.Scanner;
//
//public class JKad26S1 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int num[] = new int[99];
//        int cnt;
//        while (true){
//            System.out.println("現在、残っている数：");
//            cnt = 0;
//            for (int i = 0; i < num.length; i++) {
//                num[i] = i + 2;
//                System.out.print(i+"\t");
//                cnt++;
//            }
//            System.out.println();
//            System.out.print("何の倍数を省きますか？");
//            int a;
//            a = in.nextInt();
//            for (int i = 2;i <= num.length / 2;i++){
//                if(a * i <=100 && num[a * i] == true){
//                    num[a * i] = false;
//
//                }
//            }
//
//        }
//    }
//}
