package handler.impl;

import handler.CommandHandler;

public class MenuCommandHandlerImpl implements CommandHandler {
    @Override
    public void handle() {
        System.out.println("This application calculates the sum of all digits in a number\n");
        System.out.println("Please enter a command to process:");
        System.out.println("1 - calculate");
        System.out.println("2 - quit");
    }
}
