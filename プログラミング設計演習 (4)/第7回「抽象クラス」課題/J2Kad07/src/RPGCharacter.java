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
    public void useItem() { System.out.println("�����̃A�C�e�����g���܂��I"); }

    public void heal(){}

    public void steal(){}
    }

