/*
	課題名：J2Kad20B「コレクションとラムダ式」
	作成日：2023/12/07
	作成者：田中太郎
*/
import java.util.ArrayList;

public class J2Kad20B {
    public static void main(String[] args) {
        ArrayList<Point> pointList = new ArrayList<>();
        pointList.add(new Point());
        pointList.add(new Point());
        pointList.add(new Point());
        pointList.add(new Point());

        System.out.println("更新前のデータを表示します！");
        //拡張for文 for(型名　変数名 : 配列コレクションなど)
        for (Point p: pointList ){
            p.printInfo();
        }
        //　foreachとラムダ式に変更
        pointList.forEach(p -> p.printInfo());
        // pointList.forEach(Point::printInfo); さらに省略?

        System.out.println("2倍します！");
        for(Point p: pointList){
            p.x *= 2;
            p.y *= 2;
        }
        //　foreachとラムダ式に変更 {}は1行の時にしか省略できない
        pointList.forEach(p -> { p.x *= 2;p.y *= 2;} );

        System.out.println("更新後のデータを表示します！");
        for (Point p: pointList){
            p.printInfo();
        }
        // foreachとラムダ式に変更
        pointList.forEach(p -> p.printInfo());

    }
}
