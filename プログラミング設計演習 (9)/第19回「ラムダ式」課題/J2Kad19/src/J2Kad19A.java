interface SimpleInterface {
    int doSomething(int n);
}

public class J2Kad19A {
    static void printout(SimpleInterface i) {
        System.out.println(i.doSomething(2));
    }

    public static void main(String[] args) {
        // �@ ���Ƃ̃����_��
        printout((int n) -> {
            return n + 1;
        });

        // �A �����̌^���ȗ�
        printout((n) -> {
            return n + 1;
        });

        // �B �������͂�()���ȗ�
        printout(n -> {
            return n + 1;
        });

        // �C ���ߕ���{}��;���ȗ�
        printout(n -> n + 1);
    }
}
