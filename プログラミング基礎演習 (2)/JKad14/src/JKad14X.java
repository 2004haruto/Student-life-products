import java.util.Scanner;

public class JKad14X {
    public static void main(String[]args){
        System.out.println("あなたは勇者です");
        System.out.println("頑張ってしろまでたどりついてください");
        System.out.println();
        gotoTown();
        System.out.print("←町");
    }
    public static void gotoTown(){
        Scanner in =new Scanner(System.in);
        System.out.println("あなたは町にいます");
        System.out.print("どちらに進みますか？（1：草原　2：森）");
        int a= in.nextInt();
        if (1==a){
            gotoGrassland();
            System.out.print("←草原");
        }else if (2==a){
            gotoForest();
            System.out.print("←森");
        }

    }
    public static void gotoGrassland(){
        Scanner in =new Scanner(System.in);
        System.out.println("あなたは草原にいます");
        System.out.print("どちらに進みますか？（1：　町2：森）");
        int a= in.nextInt();
        if (1==a){
            gotoTown();
            System.out.print("←町");
        }else if (2==a){
            gotoForest();
            System.out.print("←森");
        }

    }
    public static void gotoForest(){
        Scanner in =new Scanner(System.in);
        System.out.println("あなたは森にいます");
        System.out.print("どちらに進みますか？（1：草原　2：荒地）");
        int a= in.nextInt();
        if (1==a){
            gotoGrassland();
            System.out.print("←草原");
        }else if (2==a){
            gotoWasteland();
            System.out.print("←荒地");
        }

    }
    public static void gotoWasteland(){
        Scanner in =new Scanner(System.in);
        System.out.println("あなたは荒地にいます");
        System.out.print("どちらに進みますか？（1：草原　2：洞窟）");
        int a= in.nextInt();
        if (1==a){
            gotoGrassland();
            System.out.print("←草原");
        }else if (2==a){
            gotoCave();
            System.out.print("←洞窟");
        }

    }
    public static void gotoCave(){
        Scanner in =new Scanner(System.in);
        System.out.println("あなたは洞窟にいます");
        System.out.print("どちらに進みますか？（1：森　2：城）");
        int a= in.nextInt();
        if (1==a){
            gotoForest();
            System.out.print("←森");
        }else if (2==a){
            gotoCastle();
            System.out.print("←城");
        }

    }
    public static void gotoCastle(){

        System.out.println("城につきました！");
        System.out.println("履歴を表示します！");

    }
}