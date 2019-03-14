package com.redcompany.red.jaxbcategory.ref.view.console;

import com.redcompany.red.jaxbcategory.ref.controller.ActionConsole;
import com.redcompany.red.jaxbcategory.ref.controller.Controller;
import com.redcompany.red.jaxbcategory.ref.controller.command.util.CommandName;
import com.redcompany.red.jaxbcategory.ref.entity.Category;
import com.redcompany.red.jaxbcategory.ref.entity.service.ResponseParam;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.util.HashMap;
import java.util.Scanner;

import static com.redcompany.red.jaxbcategory.ref.controller.util.RequestParameterName.*;
import static com.redcompany.red.jaxbcategory.ref.service.util.ServiceConstantStorage.JAXB_CONTEXT_PATH;

public class ConsoleShow  {

    private HashMap<String, String> action = new HashMap<>();
    private ResponseParam responseParam;

    public void startConsoleView() {
        while (true) {
            showBasicMenu();
            readUserInput();
        }
    }
    private void showBasicMenu() {
        System.out.println("____________________");
        System.out.println("1 - Show All News");
        System.out.println("2 - Add News");
        System.out.println("9 - Generate Entity from XML (Edit pom.xml)");
        System.out.println("0 - Exit");
        System.out.println("____________________");
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
                action.put(COMMAND_NAME, CommandName.ALL_NEWS_COMMAND.toString());
                sendAction(action);
                consoleAnswer(CommandName.ALL_NEWS_COMMAND.toString(), responseParam.isRequestCompleted());
                consoleShow(responseParam);
                break;
            case 2:
                action.put(COMMAND_NAME, CommandName.ADD_NEWS_COMMAND.toString());
                constructNewsParam();
                sendAction(action);
                consoleAnswer(CommandName.ADD_NEWS_COMMAND.toString(), responseParam.isRequestCompleted());
                consoleShow(responseParam);
                break;
            case 9:
                action.put(COMMAND_NAME, CommandName.XJCE_GENERATION_COMMAND.toString());
                sendAction(action);
                break;
            case 0:
                System.exit(0);
                break;
        }
    }

    public void sendAction(HashMap<String, String> action) {
        Controller controller = Controller.getInstance();
        responseParam = controller.doAction(action);
    }

    public void consoleShow(ResponseParam responseParam) {
        try {
            JAXBContext context = JAXBContext.newInstance(JAXB_CONTEXT_PATH);
            Marshaller marshaller = null;
            marshaller = context.createMarshaller();
            try {
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            } catch (PropertyException e) {
                e.printStackTrace();
                System.out.println("PropertyException: Console");
                //logger
            }
            Category category = responseParam.getCategory();
            marshaller.marshal(category, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
            System.out.println("JAXBException: Console");
            //logger
        }
    }

    private void consoleAnswer(String param, boolean answer) {
        if (answer == true) {
            System.out.println("Action: " + param + " was successful");
            System.out.println("______________________________________");
        } else {
            System.out.println("Action: " + param + " was not successful! Try Again!");
            System.out.println("______________________________________");
        }
    }


    private void constructNewsParam(){
        action.put("param", CommandName.ADD_NEWS_COMMAND.toString());
        System.out.println("Add title:");
        action.put("title", readMenuItemString());
        System.out.println("Add director:");
        action.put("director", readMenuItemString());
        System.out.println("Add date_of_issue (Format dd.MM.yyyy):");
        action.put("date_of_issue", readMenuItemString());
        System.out.println("Add news_body:");
        action.put("news_body", readMenuItemString());
    }

    private String readMenuItemString() {
        System.out.print("Input field: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        return str;
    }
}
