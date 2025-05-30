public class JKad11X {
    public static void main(String[] args) {
        int a = 1;
        while ( a<=40) {
            if ( a%3==0 && a%5==0 ) {
                System.out.println("FizzBuzzI");
            }else if ( a%3==0 ) {
                System.out.println("FizzI");
            }else if ( a%5==0 ) {
                System.out.println("BuzzI");
            }else{
                System.out.println(a);
            }
            a++;
        }
    }
}
