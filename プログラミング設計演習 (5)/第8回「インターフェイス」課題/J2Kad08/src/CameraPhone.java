public class CameraPhone implements ICamera,IPhone{

    public CameraPhone(){
        System.out.println("�J�����t�H����������I");
    }

    public void getApp(){
        System.out.println("�����̃A�v������ɓ���܂����I");
    }

    @Override
    public void takePicture() {
        System.out.println("�����̎ʐ^���B��܂����I");

    }

    @Override
    public void displayImage() {
        System.out.println("�����̎ʐ^��\�����܂����I");
    }

    @Override
    public void call() {
        System.out.println("�N���ɓd�b�������܂����I");
    }
}
