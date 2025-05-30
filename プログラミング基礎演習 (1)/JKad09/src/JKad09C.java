import java.util.Scanner;

public class JKad09C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("‚Ð‚Æ‚èˆê‚Â‚¸‚ÂƒŠƒ“ƒS‚ðH‚×‚Ü‚·I");
        System.out.print("ƒŠƒ“ƒS‚Ì”‚ð“ü—Í‚µ‚Ä‚­‚¾‚³‚¢>");
        int a = sc.nextInt();
        System.out.print("H‚×‚él‚Ì”‚ð“ü—Í‚µ‚Ä‚­‚¾‚³‚¢>");
        int b = sc.nextInt();
        if ( a<b ) {
            System.out.println("ƒŠƒ“ƒS‚Ì”‚ª‘«‚è‚Ü‚¹‚ñI");

        } else {
            System.out.println("‚Ð‚Æ‚èˆê‚Â‚¸‚ÂƒŠƒ“ƒS‚ðH‚×‚½I");
            System.out.println("Žc‚Á‚½ƒŠƒ“ƒS‚Í" +( a-b )+ "‚Å‚·I");
        }
    }
}
