import java.util.Scanner;

public class JKad26D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("�̂ё��͉����o���܂����H�i0�F�O�[�A1�F�`���L�A2�F�p�[�j��");
        int a = in.nextInt();
        String[] strHands = {"�O�[", "�`���L", "�p�["};
        System.out.println("�̂ё���"+strHands[a]+"���o����!");
        int b = (int)(Math.random()*3);
        System.out.println("��������"+strHands[b]+"���o����!");

    }
}
