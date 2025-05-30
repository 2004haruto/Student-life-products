public class CameraPhone implements ICamera,IPhone{

    public CameraPhone(){
        System.out.println("カメラフォンを作った！");
    }

    public void getApp(){
        System.out.println("何かのアプリを手に入れました！");
    }

    @Override
    public void takePicture() {
        System.out.println("何かの写真を撮りました！");

    }

    @Override
    public void displayImage() {
        System.out.println("何かの写真を表示しました！");
    }

    @Override
    public void call() {
        System.out.println("誰かに電話をかけました！");
    }
}
