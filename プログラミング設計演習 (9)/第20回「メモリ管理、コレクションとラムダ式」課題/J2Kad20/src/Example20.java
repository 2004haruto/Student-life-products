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

        //�g��for���̕��K
        for (Monster m:monsters) {
            m.show();
        }

        //�R���N�V������forEach���g��
        monsters.forEach(m -> { m.show(); } );
        monsters.forEach(m ->  m.show() );
        monsters.forEach(Monster::show);

        // �R���N�V�����̕��ёւ�
        ArrayList<Integer> numbers = new ArrayList<>();
        Random ran = new Random();
        for (int i = 0; i < 10; i++) {
            numbers.add(ran.nextInt(10));
        }
        // ���ёւ�
        Collections.sort(numbers);
        // �����_���ŋL�q
        numbers.forEach(n -> System.out.println(n));


        // ���ёւ�
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
            "�s�`���[","�s�J�`���E","���C�`���E",
    };

    static String[] typeList ={
            "��","��","�d�C"
    };

    public Monster(){
        this.name = nameList[ran.nextInt(nameList.length)];
        this.type = typeList[ran.nextInt(typeList.length)];
        this.attack = ran.nextInt(100);
    }
    void show(){
        System.out.println("�l�̖��O��"+name +"!�A������"+type+"�A�U���͂�"+attack);
    }

    @Override
    public int compareTo(Monster m) {
        return this.attack - m.attack;
    }
}
