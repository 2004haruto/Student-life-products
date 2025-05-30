package pac21x;

public abstract class Bird {
    protected boolean evolved = false;
    public abstract void fly();
    public abstract void swim();
    public abstract void evolve();
}
class Duck extends Bird {
    public Duck() {
        System.out.println("ぼくアヒル！");
        System.out.println("飛べないけど泳げるよ！");
    }
    public void fly() {
        if (!evolved) {
            System.out.println("う～ん、飛べない！！");
        } else {
            System.out.println("バタバタ！がんばって飛んでいます！！");
        }
    }
    public void swim() {
        System.out.println("スイスイ！水面を泳いでいます！！");
    }
    public void evolve() {
        System.out.println("空を飛べるようになった！！");
        evolved = true;
    }
}
class Crow extends Bird {
    public Crow() {
        System.out.println("俺さまカラス！");
        System.out.println("飛ぶのは得意だけど泳げないんだ！！");
    }
    public void fly() {
        if (!evolved) {
            System.out.println("バタバタ！がんばって飛んでいます！！");
        } else {
            System.out.println("ビューン！ジェット噴射で飛んでいきました！！");
        }
    }
    public void swim() { System.out.println("う～ん、泳げない！！"); }
    public void evolve() {
        System.out.println("ジェット噴射を装備したぜ！！");
        evolved = true;
    }
}
class Seagull extends Bird {
    public Seagull() {
        System.out.println("私はカモメ！");
        System.out.println("空も飛べるし泳ぎも得意さ！！");
    }
    public void fly() { System.out.println("バタバタ！がんばって飛んでいます！！"); }
    public void swim() {
        if (!evolved) {
            System.out.println("スイスイ！水面を泳いでいます！！");
        } else {
            System.out.println("ざっぷーん！潜って泳いでいます！！");
        }
    }
    public void evolve() {
        System.out.println("潜れるようになった！！");
        evolved = true;
    }
}
class Chicken extends Bird {
    public Chicken() {
        System.out.println("おいらニワトリ！！");
        System.out.println("飛ぶのも泳ぐのも苦手だなあ～");
    }
    public void fly() {
        if (!evolved) {
            System.out.println("う～ん、飛べない！！");
        } else {
            System.out.println("バタバタ！がんばって飛んでいます！！");
        }
    }
    public void swim() {
        if (!evolved) {
            System.out.println("う～ん、泳げない！！");
        } else {
            System.out.println("スイスイ！水面を泳いでいます！！");
        }
    }
    public void evolve() {
        System.out.println("空を飛べるよ！泳ぎもできるよ！！");
        evolved = true;
    }
}
