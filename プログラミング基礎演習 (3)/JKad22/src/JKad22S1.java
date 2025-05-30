public class JKad22S1 {
    public static void main(String[] args) {
        for (int i = 8; i > -1; i--) {
            System.out.print("");
            for (int j = 0; j < 9 - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i + 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 0; i < 9; i++) {
            System.out.print("");
            for (int j = 0; j < 9 - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i + 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

