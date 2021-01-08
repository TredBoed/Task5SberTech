package com.school3;


import java.io.IOException;
import java.util.Scanner;

public class Controller {
    private Viewer display;

    public Controller() {
        this.display = new Viewer();
    }

    public void SendToDisplay(String outputMessage) {
        this.display.setMessage(outputMessage);
        this.display.PrintMessage();
    }

    public int InputData() {
        Boolean isAllowed = false;
        String s = "";
        while (isAllowed == false) {
            Scanner sc = new Scanner(System.in).useDelimiter("\\s*");
            s = sc.nextLine();
            for (int i = 0; i < s.length(); i++) {
                if (!Character.isDigit(s.charAt(i))) {
                    isAllowed = false;
                    SendToDisplay("No letters are allowed, try again");
                    break;
                } else {
                    isAllowed = true;
                }
            }
        }
        return Integer.parseInt(s);
    }

    public String InputPin() {
        Boolean isAllowed = false;
        String pin = "";
        while (isAllowed == false) {
            Scanner sc = new Scanner(System.in).useDelimiter("\\s*");
            int counter = 0;
            pin = "";
            while (counter < 4) {
                char ch = sc.next().charAt(0);
                pin = pin + ch;
                counter++;
            }
            for (int i = 0; i < pin.length(); i++) {
                if (!Character.isDigit(pin.charAt(i))) {
                    isAllowed = false;
                    SendToDisplay("No letters are allowed in the PIN, try again");
                    break;
                } else {
                    isAllowed = true;
                }
            }
        }
        SendToDisplay(pin + " -> [X][X][X][X]");
        return pin;
    }

}

