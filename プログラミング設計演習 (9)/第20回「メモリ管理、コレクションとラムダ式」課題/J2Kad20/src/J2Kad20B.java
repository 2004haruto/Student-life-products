/*
	�ۑ薼�FJ2Kad20B�u�R���N�V�����ƃ����_���v
	�쐬���F2023/12/07
	�쐬�ҁF�c�����Y
*/
import java.util.ArrayList;

public class J2Kad20B {
    public static void main(String[] args) {
        ArrayList<Point> pointList = new ArrayList<>();
        pointList.add(new Point());
        pointList.add(new Point());
        pointList.add(new Point());
        pointList.add(new Point());

        System.out.println("�X�V�O�̃f�[�^��\�����܂��I");
        //�g��for�� for(�^���@�ϐ��� : �z��R���N�V�����Ȃ�)
        for (Point p: pointList ){
            p.printInfo();
        }
        //�@foreach�ƃ����_���ɕύX
        pointList.forEach(p -> p.printInfo());
        // pointList.forEach(Point::printInfo); ����ɏȗ�?

        System.out.println("2�{���܂��I");
        for(Point p: pointList){
            p.x *= 2;
            p.y *= 2;
        }
        //�@foreach�ƃ����_���ɕύX {}��1�s�̎��ɂ����ȗ��ł��Ȃ�
        pointList.forEach(p -> { p.x *= 2;p.y *= 2;} );

        System.out.println("�X�V��̃f�[�^��\�����܂��I");
        for (Point p: pointList){
            p.printInfo();
        }
        // foreach�ƃ����_���ɕύX
        pointList.forEach(p -> p.printInfo());

    }
}
