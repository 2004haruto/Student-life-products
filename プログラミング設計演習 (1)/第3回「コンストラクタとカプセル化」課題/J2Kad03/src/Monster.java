public class Monster {
    private String name;
    private int hp;

    public Monster(){
        setData("まだないよ〜",1);
    }

    public Monster(String n, int h){
        setData(n,h);
    }

    public void setData(String n, int h) {
        name = n;
        hp = h;
    }

    public void setName(String name){
        if (name.equals("ゲレゲレ")){
            System.out.println("ゲレゲレなんていやだ〜");
        }
    }

    public void setHp(int hp){
        if ( hp < 0 ){
            System.out.println("せめてHP、1 はちょうだい！");
            this.hp =  1;
        }
    }

    public void showData() {
        System.out.println("ぼくの名前は" + name + "、HPは" + hp + "だよ！");
    }
    public void walk() {
        if (hp <= 0) {
            System.out.println("つかれて歩けないよ〜");
            return;
        }
        System.out.println("てくてく・・・");
        hp--;
    }
    public void sleep() {
        System.out.println("ぐうぐう・・・");
        hp++;
    }

}
