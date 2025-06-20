/*
    課題名：J2Kad02B「基本型と参照型」
    作成日：2023/09/28
    作成者：正木陽斗
 */

public class J2Kad02B {
    public static void addInt(int x){
        x = x + 5;
        System.out.println("x に5 を加算しました！");
    }
    public static void addArray(int[] b){
        for (int i = 0;i < b.length; i++){
            b[i] += 5;
            System.out.println("b["+i+"]に5を加算しました!");
        }
    }

    public static void main(String[] args) {
        int x = 10;
        System.out.println("x:"+x);
        addInt(x);
        System.out.println("x:"+x);
        //int [] num = {10,20,30};
        int [] a = new int[3];
        a[0] = 10;
        a[1] = 20;
        a[2] = 30;
        System.out.println("a:"+a[0]+""+a[1]+""+a[2]+"");
        addArray(a);
        System.out.println("a:"+a[0]+""+a[1]+""+a[2]+"");
    }
}
