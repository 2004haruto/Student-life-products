import java.util.LinkedList;
import java.util.Scanner;

public class J2Kad10A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // LinkedListの宣言
        LinkedList<Monster>list=new LinkedList<Monster>();

        while(true) {
            // データの表示
            System.out.print("現在のリスト：");
            for (var data:list){
                System.out.print(data+"->");
            }


            System.out.println();
            // コマンド入力
            System.out.print("どうしますか？（0：addFirst、1：addLast、2：removeFirst、3：removeLast、-1：終了）＞");
            int cmd = in.nextInt();
            if (cmd < 0) break;
            switch (cmd){
                case 0:
                    list.addFirst(new Monster());
                    System.out.println("先頭に"+list.getFirst()+"を追加した！");
                    break;
                case 1:
                    list.addLast(new Monster());
                    System.out.println("最後に"+list.getLast()+"を追加した！");
                    break;
                case 2:
                    if(list.isEmpty()){
                        System.out.println("誰もいない！");
                    }else {
                        Monster n=list.removeFirst();
                        System.out.println("先頭の"+n+"を削除した！");
                    }
                    break;
                case 3:
                    if(list.isEmpty()){
                        System.out.println("誰もいない！");
                    }else {
                        Monster m = list.removeLast();
                        System.out.println("最後の" + m + "を削除した！");
                    }
                    break;
            }




            System.out.println();
        }
    }
}
