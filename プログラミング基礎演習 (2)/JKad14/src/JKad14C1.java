public class JKad14C1 {
    public static void main(String[] args) {
        System.out.println("�͂��߂Ă̂������I");
        System.out.println("�̂ё����P�[�L�𔃂��ɍs���܂��I");
        gotoPark();
        System.out.println("�����߂��Ă��܂����I");
    }
    public static void gotoPark(){
        System.out.println("�����ɒ����܂����I");
        gotoPostOffice();
        System.out.println("�����ɖ߂��Ă��܂����I");
    }
    public static void gotoPostOffice(){
        System.out.println("�X�֋ǂɒ����܂����I");
        gotoBank();
        System.out.println("�X�֋ǂɖ߂��Ă��܂����I");
    }
    public static void gotoBank(){
        System.out.println("��s�ɒ����܂����I");
        gotoCakeShop();
        System.out.println("��s�ɖ߂��Ă��܂����I");
    }
    public static void gotoCakeShop(){
        System.out.println("�P�[�L���ɒ����܂����I");
        System.out.println("*** �P�[�L�𔃂��܂����I ***");
        System.out.println("�߂�܂�");
    }

}
