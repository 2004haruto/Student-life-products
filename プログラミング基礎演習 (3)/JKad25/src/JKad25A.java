public class JKad25A {
    public static void main(String[] args) {
        String str1 = new String("ECC Computer");
        String str2 = new String("ECC Computer");

        System.out.println("str1は”" + str1 + "”です！");
        System.out.println("str2は”" + str2 + "”です！");

        boolean equal1 = (str1 == str2);
        System.out.println("==(比較演算子)で比較しました！" + equal1);

        boolean equal2 = str1.equals(str2);
        System.out.println("eauqls メソッドで比較しました！" + equal2);

        boolean equal3 = false;
        for (int i = 0; i < str1.length() && i < str2.length(); i++){
            char code1 = str1.charAt(i);
            char code2 = str2.charAt(i);

            if (code1 == code2) {
                equal3 = true;
            }
        }
        System.out.println("一文字ずつがんばって比較しました！" + equal3);
    }
}