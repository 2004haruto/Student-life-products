interface SimpleInterface {
    int doSomething(int n);
}

public class J2Kad19A {
    static void printout(SimpleInterface i) {
        System.out.println(i.doSomething(2));
    }

    public static void main(String[] args) {
        // ‡@ ‚à‚Æ‚Ìƒ‰ƒ€ƒ_Ž®
        printout((int n) -> {
            return n + 1;
        });

        // ‡A ˆø”‚ÌŒ^‚ðÈ—ª
        printout((n) -> {
            return n + 1;
        });

        // ‡B ˆø”‚ðˆÍ‚Þ()‚ðÈ—ª
        printout(n -> {
            return n + 1;
        });

        // ‡C –½—ß•¶‚Ì{}‚Æ;‚ðÈ—ª
        printout(n -> n + 1);
    }
}
