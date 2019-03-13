package com.redcompany.red.jaxbcategory.ref.view.console;

import com.redcompany.red.jaxbcategory.ref.controller.ActionConsole;
import com.redcompany.red.jaxbcategory.ref.controller.Controller;
import com.redcompany.red.jaxbcategory.ref.controller.command.util.CommandName;

import java.util.HashMap;
import java.util.Scanner;

import static com.redcompany.red.jaxbcategory.ref.controller.util.RequestParameterName.*;

public class ConsoleShow  {

    private HashMap<String, String> action = new HashMap<>();


    public void startConsoleView() {
        while (true) {
            showBasicMenu();
            readUserInput();
        }
    }
    private void showBasicMenu() {
        System.out.println("1 - Show All News");
        System.out.println("2 - Add News");
        System.out.println("9 - Generate Entity from XML (Edit pom.xml)");
        System.out.println("0 - Exit");
    }

    private void readUserInput() {
        int item = readMenuItem();
        getInputData(item);
    }

    private int readMenuItem() {
        System.out.print("Input field: ");
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        if (scanner.hasNextInt()) {
            number = scanner.nextInt();
        } else {
            System.out.println("!Exeption! Enter a number");
            readMenuItem();
        }
        return number;
    }

    private void getInputData(int menuItem) {
        switch (menuItem) {
            case 1:
                break;
            case 9:
                action.put(COMMAND_NAME, CommandName.XJCEGENERATION_COMMAND.toString());
                sendAction(action);
                break;
            case 0:
                System.exit(0);
                break;
        }
    }

    public HashMap<String, String> sendAction(HashMap<String, String> action) {
        Controller controller = Controller.getInstance();
        controller.doAction(action);
        return null;
    }
}
