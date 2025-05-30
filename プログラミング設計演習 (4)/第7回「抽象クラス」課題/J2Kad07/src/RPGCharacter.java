public abstract class RPGCharacter {

    public void callAllMethod(){
        attack();
        defend();
        useItem();
        heal();
        steal();
    }

    public  abstract void attack();
    public abstract void defend();
    public void useItem() { System.out.println("何かのアイテムを使います！"); }

    public void heal(){}

    public void steal(){}
    }

