public class JKad25B {
    public static void main(String[] args) {
        for (int a = 0;a<=0xff;a++){
            if ( a=='\b' || a=='\t' || a=='\n' || a=='\r'){
                System.out.print(".\t");
            }else {
                System.out.print((char) a + "\t");
            }
            if (a%16==15){
                System.out.println();
            }
        }
    }
}
