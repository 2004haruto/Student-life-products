public class Monster {
    public String name;
    public int hp;
    public void setData(String n, int h){
        name = n;
        hp = h;
    }
    public void showData(){
        System.out.println("ぼくの名前は" + name + "、HPは" + hp + "だよ！");
    }
    public void walk(){
        if (hp <= 0) {
            System.out.println("つかれて歩けないよ～");
        }else{
            System.out.println("てくてく・・・");
            hp--;
        }
    }
    public void sleep(){
        System.out.println("ぐうぐう・・・");
        hp++;
    }
}
