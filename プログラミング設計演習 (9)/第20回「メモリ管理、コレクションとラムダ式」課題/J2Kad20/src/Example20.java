import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Example20 {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().freeMemory());

        ArrayList<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster());
        monsters.add(new Monster());
        monsters.add(new Monster());

        //拡張for文の復習
        for (Monster m:monsters) {
            m.show();
        }

        //コレクションでforEachを使う
        monsters.forEach(m -> { m.show(); } );
        monsters.forEach(m ->  m.show() );
        monsters.forEach(Monster::show);

        // コレクションの並び替え
        ArrayList<Integer> numbers = new ArrayList<>();
        Random ran = new Random();
        for (int i = 0; i < 10; i++) {
            numbers.add(ran.nextInt(10));
        }
        // 並び替え
        Collections.sort(numbers);
        // ラムダ式で記述
        numbers.forEach(n -> System.out.println(n));


        // 並び替え
        Collections.sort(monsters);
        monsters.forEach(m -> m.show());

    }
}

class Monster implements Comparable<Monster>{
    String name;
    String type;
    int attack ;
    static Random ran = new Random();
    static String[] nameList ={
            "ピチュー","ピカチュウ","ライチュウ",
    };

    static String[] typeList ={
            "炎","水","電気"
    };

    public Monster(){
        this.name = nameList[ran.nextInt(nameList.length)];
        this.type = typeList[ran.nextInt(typeList.length)];
        this.attack = ran.nextInt(100);
    }
    void show(){
        System.out.println("僕の名前は"+name +"!、属性は"+type+"、攻撃力は"+attack);
    }

    @Override
    public int compareTo(Monster m) {
        return this.attack - m.attack;
    }
}
