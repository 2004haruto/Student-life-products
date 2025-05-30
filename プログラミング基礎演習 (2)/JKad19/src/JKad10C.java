public class JKad10C {
    public static void main(String[] args) {
        int []cards = {1,2,3,4,5,6,7,8,9};
        System.out.println("カードが"+cards.length+" 枚あります！");
        System.out.println("カードを順番に表示します！");
        int a = 0;
        while (a<cards.length){
            System.out.println("cards["+a+"]:"+cards[a]);
            a++;
        }
    }
}
