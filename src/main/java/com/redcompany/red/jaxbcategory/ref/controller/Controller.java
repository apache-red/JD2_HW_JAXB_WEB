package com.redcompany.red.jaxbcategory.ref.controller;

import com.redcompany.red.jaxbcategory.ref.controller.command.BasicCommand;
import com.redcompany.red.jaxbcategory.ref.controller.command.CommandManager;
import com.redcompany.red.jaxbcategory.ref.entity.service.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

import static com.redcompany.red.jaxbcategory.ref.controller.util.RequestParameterName.*;

public class Controller extends HttpServlet implements ActionConsole {

    private static final Controller instance = new Controller();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    public HashMap<String, String> doAction(HashMap<String, String> action) {
        String commandName = action.get(COMMAND_NAME);
        BasicCommand command = CommandManager.getInstance().getCommand(commandName);
        command.performAction(constractRequest(action));
        return null;
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
