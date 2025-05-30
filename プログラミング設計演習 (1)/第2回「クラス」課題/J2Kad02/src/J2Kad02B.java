/*
    ‰Û‘è–¼FJ2Kad02BuŠî–{Œ^‚ÆQÆŒ^v
    ì¬“úF2023/09/28
    ì¬ÒF³–Ø—z“l
 */

public class J2Kad02B {
    public static void addInt(int x){
        x = x + 5;
        System.out.println("x ‚É5 ‚ğ‰ÁZ‚µ‚Ü‚µ‚½I");
    }
    public static void addArray(int[] b){
        for (int i = 0;i < b.length; i++){
            b[i] += 5;
            System.out.println("b["+i+"]‚É5‚ğ‰ÁZ‚µ‚Ü‚µ‚½!");
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
