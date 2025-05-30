public class RockMonster extends Monster{
    public RockMonster(String name){
        super(name);
    }
    public void defend(){
        System.out.println(name + "`‚Í–hŒä‚µ‚Ä‚¢‚éIƒ_ƒ[ƒW‚ğ—^‚¦‚ç‚ê‚È‚¢!!");
    }
    public void intro(){
        super.intro();
        System.out.println("‚Æ‚Ä‚àd‚¢‚ºI");
    }
}
