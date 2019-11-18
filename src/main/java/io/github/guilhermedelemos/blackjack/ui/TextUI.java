package io.github.guilhermedelemos.blackjack.ui;

import java.util.Scanner;

public class TextUI {

    private Scanner scanner;

    public TextUI() {
        super();
        this.scanner = new Scanner(System.in);
    }

    public String read(String message) {
        this.println(message);
        return this.scanner.next();
    }

    public void println(String message) {
        System.out.println(message);
    }

    public void sleep() {
        try {
            Thread.currentThread().sleep(1000);
        }catch(InterruptedException e) {
        }
    }

}
