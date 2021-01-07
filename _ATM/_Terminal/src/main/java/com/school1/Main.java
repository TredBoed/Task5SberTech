package com.school1;

import com.school3.Controller;

public class Main {
    public static Integer userId = 45678;
    public static Controller controller = new Controller();

    public static void main(String args[]) {
        //Goto ATM to use Terminal
        //You inserted plastic card and you are trying to get access to the user account id: 45678
        TerminalImpl terminal = new TerminalImpl(userId);
        ATMstart(terminal);
    }

    public static void ATMstart(TerminalImpl terminal) {
        terminal.Start();

        controller.SendToDisplay("Hello user: " + userId);
        controller.SendToDisplay("1.Check balance\n2.Deposit\n3.Withdraw\n4.Exit");

        while (true) {
            switch (controller.InputData()) {
                case 1:
                    terminal.CheckBalance();
                    break;
                case 2:
                    terminal.Deposit();
                    break;
                case 3:
                    terminal.WithDraw();
                    break;
                case 4:
                    terminal.Exit();
                    break;
            }
        }
    }
}
