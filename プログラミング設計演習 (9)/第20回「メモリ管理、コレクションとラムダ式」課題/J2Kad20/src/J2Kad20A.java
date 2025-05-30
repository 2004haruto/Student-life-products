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

        System.out.println("更新前のデータを表示します！");
        for (Point point : pointList) {
            point.printInfo();
        }

        // パターンA: ArrayListのsortメソッドとラムダ式を使用
        Collections.sort(pointList, Comparator.comparingInt(p -> p.x + p.y));

        System.out.println("パターンAでの更新後のデータを表示します！");
        for (Point point : pointList) {
            point.printInfo();
        }

        // パターンB: Comparatorを使用して手動でソート
        pointList.sort(Comparator.comparingInt(p -> p.x + p.y));

        System.out.println("パターンBでの更新後のデータを表示します！");
        for (Point point : pointList) {
            point.printInfo();
        }
    }
}
