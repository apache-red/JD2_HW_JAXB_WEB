package com.redcompany.red.jaxbcategory.ref.controller;

import com.redcompany.red.jaxbcategory.ref.controller.command.BasicCommand;
import com.redcompany.red.jaxbcategory.ref.controller.command.CommandManager;
import com.redcompany.red.jaxbcategory.ref.entity.service.RequestParam;
import com.redcompany.red.jaxbcategory.ref.entity.service.ResponseParam;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import static com.redcompany.red.jaxbcategory.ref.controller.util.RequestParameterName.*;
import static com.redcompany.red.jaxbcategory.ref.service.util.ServiceConstantStorage.XML_FILE_PATH;

@WebServlet("/Controller")
public class Controller extends HttpServlet implements ActionConsole {

    private static final Controller instance = new Controller();
    private ResponseParam responseParam;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println();
        super.doPost(req, resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    public ResponseParam doAction(HashMap<String, String> action) {
        if (isFile(XML_FILE_PATH) == true) {
            String commandName = action.get(COMMAND_NAME);
            BasicCommand command = CommandManager.getInstance().getCommand(commandName);
            try {
                responseParam = command.performAction(constractRequest(action));
            } catch (JAXBException e) {
                e.printStackTrace();
                System.out.println("JAXBException");
                //logger
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Exception");
                //logger
            }
            return responseParam;
        } else {
            System.out.println("File is not found!");
            responseParam.setRequestCompleted(false);
            return responseParam;
        }
    }

    private boolean isFile(String filePath) {
        if ((new File(filePath)).isFile()) {
            return true;
        } else {
            return false;
        }
    }


    private RequestParam constractRequest(HashMap<String, String> action) {
        return new RequestParam(action);
    }


    private RequestParam constractRequest(HttpServletRequest req) {
// logic
        return null;
    }


    public static Controller getInstance() {
        return instance;
    }
}
