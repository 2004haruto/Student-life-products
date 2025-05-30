import java.util.LinkedList;
import java.util.Scanner;

public class J2Kad10A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // LinkedList�̐錾
        LinkedList<Monster>list=new LinkedList<Monster>();

        while(true) {
            // �f�[�^�̕\��
            System.out.print("���݂̃��X�g�F");
            for (var data:list){
                System.out.print(data+"->");
            }


            System.out.println();
            // �R�}���h����
            System.out.print("�ǂ����܂����H�i0�FaddFirst�A1�FaddLast�A2�FremoveFirst�A3�FremoveLast�A-1�F�I���j��");
            int cmd = in.nextInt();
            if (cmd < 0) break;
            switch (cmd){
                case 0:
                    list.addFirst(new Monster());
                    System.out.println("�擪��"+list.getFirst()+"��ǉ������I");
                    break;
                case 1:
                    list.addLast(new Monster());
                    System.out.println("�Ō��"+list.getLast()+"��ǉ������I");
                    break;
                case 2:
                    if(list.isEmpty()){
                        System.out.println("�N�����Ȃ��I");
                    }else {
                        Monster n=list.removeFirst();
                        System.out.println("�擪��"+n+"���폜�����I");
                    }
                    break;
                case 3:
                    if(list.isEmpty()){
                        System.out.println("�N�����Ȃ��I");
                    }else {
                        Monster m = list.removeLast();
                        System.out.println("�Ō��" + m + "���폜�����I");
                    }
                    break;
            }




            System.out.println();
        }
    }
}
