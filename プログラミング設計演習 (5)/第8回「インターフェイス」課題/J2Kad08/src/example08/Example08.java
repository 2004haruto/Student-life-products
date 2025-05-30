package example08;

import java.util.Scanner;

public class Example08 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int START_SCREEN= 0;
        final int MAIN_SCREEN = 1;
        int screen = START_SCREEN; //��ʂ̕\��

        // Command cmd = new Command(); �ł��Ȃ�
        StartScreenCommand SSCommand = new StartScreenCommand();
        MainScreenCommand  MSCommand = new MainScreenCommand();
        Command[] commands = {SSCommand,MSCommand};
        ExtenstionsCommand[] eCommands = {SSCommand,MSCommand};

        while (true){
            if(screen == START_SCREEN){
                System.out.println("ECC�Q�[���̐��E�ւ悤����!");
                System.out.print("Please enter any button  ");
            }else{
                System.out.println("�G�����ꂽ�I");
                System.out.print("�ǂ�����H ");
            }
            System.out.print("A,B,X,Y > ");
            String choice = in.next();
            switch (choice){
                case "A": commands[screen].btnA();  break;
                case "B": commands[screen].btnB();  break;
                case "X": commands[screen].btnX();  break;
                case "Y": commands[screen].btnY();  break;
                case "V": eCommands[screen].btnV(); break;
                case "W": eCommands[screen].btnW(); break;
                default: continue;  //ABXY�ȊO�͎󂯕t���Ȃ�
            }
            //�X�N���[���̐؂�ւ�
            if(screen == START_SCREEN) screen = MAIN_SCREEN;
        }

    }
}
