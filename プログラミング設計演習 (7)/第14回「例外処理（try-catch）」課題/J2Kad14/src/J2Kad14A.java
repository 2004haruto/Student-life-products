import java.util.Scanner;

public class J2Kad14A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] array = new int[10]; // �v�f����10�ɕύX

        while (true) {
            try {
                System.out.print("�����鐔����͂��Ă���������");
                String input = in.next();
                int a = Integer.parseInt(input);

                int b = (int) (Math.random() * 10); // 0����9�̗����𐶐�
                System.out.println(b + "�Ŋ���܂�!");

                if (b == 0) {
                    throw new ArithmeticException("0���Z���������܂����I");
                }

                int result = a / b;
                System.out.println("�v�Z���ʂ�" + result + "�ł�!");

                int index = (int) (Math.random() * 10); // 0����9�̗����𐶐�
                System.out.println("�z���" + index + "�ԖڂɊi�[���܂�!");

                // 0����9�܂ł̗����ɂ���āA�z��̃����_���Ȉʒu�Ɍ��ʂ��i�[
                array[index] = result;

                System.out.println("����������ɍs���܂����I");
            } catch (NumberFormatException e) {
                System.out.println("int�^�łȂ��l�����͂���܂����I");
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
                break; // 0���Z�̏ꍇ�A���[�v���甲����
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("�z��Ɋi�[�ł��܂���I");
            } finally {
                System.out.println("finally �u���b�N�̏����ł��I");
            }
        }

        System.out.println("�I�����܂��I");
        in.close();
    }
}
