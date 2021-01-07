package com.school3;

import com.school3.Viewer;

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
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        return i;
    }

    public int InputPin() {
        Scanner scan = new Scanner(System.in);
        int i = scan.nextInt();
        return i;
    }

}
