package console;

import handler.CommandHandler;
import handler.impl.ExitProgramCommandHandlerImpl;
import handler.impl.MenuCommandHandlerImpl;
import handler.impl.SumCalculatorCommandHandler;
import handler.impl.UnknownCommandHandlerImpl;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {
    private final Map<String, CommandHandler> commandHandlers = new HashMap<>();

    {
        commandHandlers.put("1", new SumCalculatorCommandHandler());
        commandHandlers.put("2", new ExitProgramCommandHandlerImpl());
        commandHandlers.put("restart", new MenuCommandHandlerImpl());
    }

    public void run() {
        new MenuCommandHandlerImpl().handle();
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        handleCommand(command);
    }

    private void handleCommand(String command) {
        while (true) {
            if (command.equals("restart")) {
                new MenuCommandHandlerImpl().handle();
                Scanner scanner = new Scanner(System.in);
                handleCommand(scanner.nextLine());
            }
            commandHandlers.getOrDefault(command, new UnknownCommandHandlerImpl()).handle();
            command = "restart";
        }
    }
}
