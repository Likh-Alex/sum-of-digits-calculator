package handler.impl;

import handler.CommandHandler;
import java.util.Scanner;

public class SumCalculatorCommandHandler implements CommandHandler {

    @Override
    public void handle() {
        promptUser();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        processInput(input);
    }

    private void promptUser() {
        System.out.println("Please enter a number up to 10 digits long: ");
    }

    public void processInput(String input) {
        boolean isFirstNumeric = input.chars().allMatch(Character::isDigit);
        if (input.length() > 10) {
            System.out.println("The number is too long, please try again\n");
            return;
        }
        if (isFirstNumeric) {
            System.out.println("The result is: " + getSumOfDigits(Integer.parseInt(input)) + "\n");
            return;
        }
        System.out.println("Bad parameters. Please try again");
    }

    private int getSumOfDigits(int number) {
        int sum = 0;
        while (number != 0) {
            sum = sum + number % 10;
            number = number / 10;
        }
        return sum;
    }
}
