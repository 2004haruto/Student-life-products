/*
	�ۑ薼�FJ2Kad18C�u��O�𓊂��悤�I�ithrow�j�v
	�쐬���F2023/11/30
	�쐬�ҁF�c�����Y
*/
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class J2Kad18C {
    public static void main(String[] args) {
        System.out.println("��O���X���[���ăL���b�`���܂��I");
        while(true) {
            try {
               throwException();
            }catch (IOException e) {
                    //��������IOException

                System.out.println(e + "���L���b�`���܂����I");


            } catch (Exception e) {
                System.out.println(e + "���L���b�`���܂����I");
                System.out.println("�I�����܂��I");
                break;
            }
            System.out.println();
        }
    }

    static void throwException() throws IOException{
        Scanner in = new Scanner(System.in);
        System.out.print("�ǂ̗�O���X���[���܂����H�i0:FileNotFoundException�A1:EOFException�j��");
        int n = Integer.parseInt(in.next());
        //0�̎��@FileNotFoundException�@�𔭐�������
        //1�̎��@EOFException �𔭐�������

            switch (n) {
                case 0:
                    throw new FileNotFoundException();
                case 1:
                    throw new EOFException();
            }
    }
}
