/*
	�ۑ薼�FJ2Kad15B�u�������I��s�֍s�����I�I�i�X���b�h�Łj�v
	�쐬���F2023/11/16
	�쐬�ҁF�c�����Y
*/

import java.util.ArrayList;

//Bank�N���X
class Bank{
    private static int money = 0;

    public static int getMoney(){
        return money;
    }
    //synchronized������Ώ��ԂɎ��s���Ă����

    public synchronized  static void addOneYen(){
        money++;
    }
}

//Customer�N���X
class Customer extends Thread{
    public Customer(){
        System.out.println("�a���҂�����Ă����I�u����΂��Ă�����a���邼�I�v");
    }

    public void run(){
        for (int i = 1;i <= 10000;i++){
            Bank.addOneYen();//��~�a����
        }
    }
}

public class J2Kad15B {
    public static void main(String[] args) {
        System.out.println("������a����̂Ȃ�M�p�ƐM����ECC��s�ցI");

        // �a���҂̕�W
        Customer[] customers = new Customer[100];
//        ArrayList<Customer> customerList = new ArrayList<>();

            //�z��o�[�W����
        for (int i = 0;i < 100;i++){
            customers[i] = new Customer();
        }
//            //ArrayList�o�[�W����
//        for (int i = 0;i < 100;i++){
//            customerList.add(new Customer());
//        }

        // �a���X�^�[�g
        //�����ɏ��ԂɎ��o�����l�����锠�̐錾�@�E���Ɍ��̔z��(�R���N�V����)
        for (Customer c: customers){
            c.start();
        }
//        //ArrayList
//        for (Customer c : customerList){
//            c.start();
//        }

        // �X���b�h�����̏I���҂�
        for (Customer c: customers){
            try {
                c.join();
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }

        // �a���z�̕\��
        System.out.println("�a���z��"+Bank.getMoney()+"�~�ł�!");


    }
}
