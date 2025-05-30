import java.util.Stack;

public class FairyMonster extends Monster implements Fairy{
    public FairyMonster(String name){
        super(name);
    }

    @Override
    public void heal() {
        System.out.println("’N‚©‚Ì‚¯‚ª‚ğ¡‚µ‚½I");
    }
}
