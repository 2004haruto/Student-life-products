package example;

public class Luffy extends Pirate{
    public Luffy(String name){
        super(name);
        System.out.println("ŠC‘¯‰¤‚É‰´‚Í‚È‚éI");
    }
    @Override
    public void attack() {
        super.attack();
        System.out.println("ƒSƒ€ƒSƒ€‚Ìe");
    }

    public void skill(){
        System.out.println("ƒSƒ€ƒSƒ€‚Ì‰¤Ö");
    }

}
