import java.util.Stack;

public class FairyMonster extends Monster implements Fairy{
    public FairyMonster(String name){
        super(name);
    }

    @Override
    public void heal() {
        System.out.println("誰かのけがを治した！");
    }
}
