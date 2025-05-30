import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class J2Kad20A {
    public static void main(String[] args) {
        ArrayList<Point> pointList = new ArrayList<>();
        pointList.add(new Point());
        pointList.add(new Point());
        pointList.add(new Point());
        pointList.add(new Point());

        System.out.println("�X�V�O�̃f�[�^��\�����܂��I");
        for (Point point : pointList) {
            point.printInfo();
        }

        // �p�^�[��A: ArrayList��sort���\�b�h�ƃ����_�����g�p
        Collections.sort(pointList, Comparator.comparingInt(p -> p.x + p.y));

        System.out.println("�p�^�[��A�ł̍X�V��̃f�[�^��\�����܂��I");
        for (Point point : pointList) {
            point.printInfo();
        }

        // �p�^�[��B: Comparator���g�p���Ď蓮�Ń\�[�g
        pointList.sort(Comparator.comparingInt(p -> p.x + p.y));

        System.out.println("�p�^�[��B�ł̍X�V��̃f�[�^��\�����܂��I");
        for (Point point : pointList) {
            point.printInfo();
        }
    }
}
