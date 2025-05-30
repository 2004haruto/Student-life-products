public class JKad25A {
    public static void main(String[] args) {
        String str1 = new String("ECC Computer");
        String str2 = new String("ECC Computer");

        System.out.println("str1‚Íh" + str1 + "h‚Å‚·I");
        System.out.println("str2‚Íh" + str2 + "h‚Å‚·I");

        boolean equal1 = (str1 == str2);
        System.out.println("==(”äŠr‰‰Zq)‚Å”äŠr‚µ‚Ü‚µ‚½I" + equal1);

        boolean equal2 = str1.equals(str2);
        System.out.println("eauqls ƒƒ\ƒbƒh‚Å”äŠr‚µ‚Ü‚µ‚½I" + equal2);

        boolean equal3 = false;
        for (int i = 0; i < str1.length() && i < str2.length(); i++){
            char code1 = str1.charAt(i);
            char code2 = str2.charAt(i);

            if (code1 == code2) {
                equal3 = true;
            }
        }
        System.out.println("ˆê•¶š‚¸‚Â‚ª‚ñ‚Î‚Á‚Ä”äŠr‚µ‚Ü‚µ‚½I" + equal3);
    }
}