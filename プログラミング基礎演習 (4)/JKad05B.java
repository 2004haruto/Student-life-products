/*
 課題名：JKad05B
 作成日：2023/4/27
 作成者：正木陽斗
*/
public class JKad05B {
	public static void main(String[] args) {
	final int COFFEE = 290; 
	int tax = (int)(COFFEE*0.08);
	int total = COFFEE+tax;
	System.out.println("ようこそ！ECCコーヒーへ\nお持ち帰りですね！");
	System.out.println("コーヒー"+COFFEE+"円、消費税"+((int)tax)+"円で合計"+total+"円になります！");
	System.out.println("ありがとうございました！");
	}
}