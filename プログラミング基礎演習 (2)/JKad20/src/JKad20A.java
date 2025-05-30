import java.util.Scanner;

public class JKad20A {
    public static void main(String[]args){
        Scanner in =new Scanner(System.in);
        System.out.print("ƒJ[ƒh‚Ì–‡”‚ğ“ü—Í‚µ‚Ä‚­‚¾‚³‚¢„");
        int a= in.nextInt();
        int [] scores;
        scores = new int[a];
        int b;

        for (b=0;b<scores.length;b++) {
            scores[b] =(int)(Math.random()*100);
            System.out.print(scores[b]+"\t");
        }
        System.out.println("\n‹t‡‚É‚µ‚Ü‚·");
        int f;
        for (b=0;b< scores.length/2;b++){
            f= scores[b];
            scores[b] = scores[scores.length-1-b];

            scores[scores.length-1-b] = f;
            showCards(scores);
        }

    }
    public static void showCards(int[]random){
        int c ;
        for (c=0;c<random.length;c++){
            System.out.print(random[c]+"\t");
        }
        System.out.println();

    }
}