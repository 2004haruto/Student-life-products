import java.util.Scanner;

public class JKad14X {
    public static void main(String[]args){
        System.out.println("���Ȃ��͗E�҂ł�");
        System.out.println("�撣���Ă���܂ł��ǂ���Ă�������");
        System.out.println();
        gotoTown();
        System.out.print("����");
    }
    public static void gotoTown(){
        Scanner in =new Scanner(System.in);
        System.out.println("���Ȃ��͒��ɂ��܂�");
        System.out.print("�ǂ���ɐi�݂܂����H�i1�F�����@2�F�X�j");
        int a= in.nextInt();
        if (1==a){
            gotoGrassland();
            System.out.print("������");
        }else if (2==a){
            gotoForest();
            System.out.print("���X");
        }

    }
    public static void gotoGrassland(){
        Scanner in =new Scanner(System.in);
        System.out.println("���Ȃ��͑����ɂ��܂�");
        System.out.print("�ǂ���ɐi�݂܂����H�i1�F�@��2�F�X�j");
        int a= in.nextInt();
        if (1==a){
            gotoTown();
            System.out.print("����");
        }else if (2==a){
            gotoForest();
            System.out.print("���X");
        }

    }
    public static void gotoForest(){
        Scanner in =new Scanner(System.in);
        System.out.println("���Ȃ��͐X�ɂ��܂�");
        System.out.print("�ǂ���ɐi�݂܂����H�i1�F�����@2�F�r�n�j");
        int a= in.nextInt();
        if (1==a){
            gotoGrassland();
            System.out.print("������");
        }else if (2==a){
            gotoWasteland();
            System.out.print("���r�n");
        }

    }
    public static void gotoWasteland(){
        Scanner in =new Scanner(System.in);
        System.out.println("���Ȃ��͍r�n�ɂ��܂�");
        System.out.print("�ǂ���ɐi�݂܂����H�i1�F�����@2�F���A�j");
        int a= in.nextInt();
        if (1==a){
            gotoGrassland();
            System.out.print("������");
        }else if (2==a){
            gotoCave();
            System.out.print("�����A");
        }

    }
    public static void gotoCave(){
        Scanner in =new Scanner(System.in);
        System.out.println("���Ȃ��͓��A�ɂ��܂�");
        System.out.print("�ǂ���ɐi�݂܂����H�i1�F�X�@2�F��j");
        int a= in.nextInt();
        if (1==a){
            gotoForest();
            System.out.print("���X");
        }else if (2==a){
            gotoCastle();
            System.out.print("����");
        }

    }
    public static void gotoCastle(){

        System.out.println("��ɂ��܂����I");
        System.out.println("������\�����܂��I");

    }
}