public class Account {
    public String name;
    public int accountNumber;
    public int money;
    public int secretNumber;
    public void setData(String n, int a, int m, int s){
        String name = n;
        accountNumber = a;
        money = m;
        secretNumber = s;
    }
    public void showData(){
        System.out.println("�������`�F"+name);
        System.out.println("�����ԍ��F"+accountNumber);
        System.out.println("�����c��: "+money);
    }
}
