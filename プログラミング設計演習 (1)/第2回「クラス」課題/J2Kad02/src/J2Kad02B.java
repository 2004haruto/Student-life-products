/*
    �ۑ薼�FJ2Kad02B�u��{�^�ƎQ�ƌ^�v
    �쐬���F2023/09/28
    �쐬�ҁF���ؗz�l
 */

public class J2Kad02B {
    public static void addInt(int x){
        x = x + 5;
        System.out.println("x ��5 �����Z���܂����I");
    }
    public static void addArray(int[] b){
        for (int i = 0;i < b.length; i++){
            b[i] += 5;
            System.out.println("b["+i+"]��5�����Z���܂���!");
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
