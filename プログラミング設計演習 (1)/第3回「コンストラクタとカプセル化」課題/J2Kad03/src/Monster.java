public class Monster {
    private String name;
    private int hp;

    public Monster(){
        setData("‚Ü‚¾‚È‚¢‚æ`",1);
    }

    public Monster(String n, int h){
        setData(n,h);
    }

    public void setData(String n, int h) {
        name = n;
        hp = h;
    }

    public void setName(String name){
        if (name.equals("ƒQƒŒƒQƒŒ")){
            System.out.println("ƒQƒŒƒQƒŒ‚È‚ñ‚Ä‚¢‚â‚¾`");
        }
    }

    public void setHp(int hp){
        if ( hp < 0 ){
            System.out.println("‚¹‚ß‚ÄHPA1 ‚Í‚¿‚å‚¤‚¾‚¢I");
            this.hp =  1;
        }
    }

    public void showData() {
        System.out.println("‚Ú‚­‚Ì–¼‘O‚Í" + name + "AHP‚Í" + hp + "‚¾‚æI");
    }
    public void walk() {
        if (hp <= 0) {
            System.out.println("‚Â‚©‚ê‚Ä•à‚¯‚È‚¢‚æ`");
            return;
        }
        System.out.println("‚Ä‚­‚Ä‚­EEE");
        hp--;
    }
    public void sleep() {
        System.out.println("‚®‚¤‚®‚¤EEE");
        hp++;
    }

}
