public class JKad19D {
    public static void main(String[] args) {
        int []a={1,2,3};
        System.out.println("[0]"+a[0]);
        System.out.println("[1]"+a[1]);
        System.out.println("[2]"+a[2]);
        int b = a[0];
        a[0]=a[2];
        a[2]=b;
        System.out.println("a[0]‚Æa[2]‚ğ“ü‚ê‘Ö‚¦‚Ü‚·I");
        System.out.println("[0]"+a[0]);
        System.out.println("[1]"+a[1]);
        System.out.println("[2]"+a[2]);
    }
}
