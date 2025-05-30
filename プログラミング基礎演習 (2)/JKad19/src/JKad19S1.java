public class JKad19S1 {
    public static void main(String[] args) {
        int [] heights =  {160, 155, 170, 150, 175, 180, 165}; // 身長データ
        System.out.println("一番背の高い人を一番後ろにします！");
        int a = 0;
        int b;
        while (a< heights.length-1) {
           if (heights[a]>heights[a+1]){
               b = heights[a];
               heights[a]=heights[a+1];
               heights[a+1]=b;
           }
            a++;
        }
        a=0;
        while (a< heights.length) {
            System.out.println("heights[" + a + "]" + heights[a]);
            a++;
        }
    }
}
