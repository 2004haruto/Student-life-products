public class JKad20B {
    public static void main(String[] args) {
        System.out.println("カードを表示します！");
        int a;
        int []score;
        score = new int[9];
        for (a = 0; a< score.length; a++){
            score[a] = (int)(Math.random()*100);
            System.out.println("cards["+a+"]:"+score[a]);
        }
        System.out.println("逆順で表示します！");
        for (a = score.length-1; a>=0; a--){
            System.out.println("cards["+a+"]:"+score[a]);
        }
    }
}
