public class Rocket {
    protected int fuel;           // �R��
    protected int height;         // ���x
    protected int speed;          // �������x
    public Rocket(int fuel, int height) {
        this.fuel = fuel;
        this.height = height;
        this.speed = 0;
        System.out.println("���P�b�g��������I");
    }
    public int getSpeed() { return speed; }
    public int getHeight() { return height; }
    public void showData() {
        System.out.println("--------------------------------");
        System.out.println("[�R��]�F" + fuel + "\t[�������x]�F" + speed + "\t[���x]�F" + height);
        System.out.println("--------------------------------");
    }
    public void useFuel() {
        if (fuel > 0) {
            System.out.println("�R�����g�����I");
            speed -= 5;         // �t���˂ɂ�錸��
            fuel--;
        } else {
            System.out.println("�R�����Ȃ��I");
        }
    }
    public void move() {
        speed += 4;                 // �d�͂ɂ�����
        height -= speed;            // ����
    }
}
