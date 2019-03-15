package com.redcompany.red.jaxbcategory.ref.controller;

import com.redcompany.red.jaxbcategory.ref.controller.command.BasicCommand;
import com.redcompany.red.jaxbcategory.ref.controller.command.CommandManager;
import com.redcompany.red.jaxbcategory.ref.controller.util.JspPageName;
import com.redcompany.red.jaxbcategory.ref.controller.util.RequestParameterName;
import com.redcompany.red.jaxbcategory.ref.entity.SubCategoryType;
import com.redcompany.red.jaxbcategory.ref.entity.service.RequestParam;
import com.redcompany.red.jaxbcategory.ref.entity.service.ResponseParam;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.redcompany.red.jaxbcategory.ref.controller.util.RequestParameterName.*;
import static com.redcompany.red.jaxbcategory.ref.service.util.ServiceConstantStorage.XML_FILE_PATH;

@WebServlet("/controller")
public class Controller extends HttpServlet implements ActionConsole {

    private static final Controller instance = new Controller();
    private ResponseParam responseParam;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page = null;
        String commandName = req.getParameter(COMMAND_NAME);
        BasicCommand command = CommandManager.getInstance().getCommand(commandName);
        try {
            responseParam = command.performAction(constractRequest(req));
            page = responseParam.getPageNames();
        } catch (JAXBException e) {
            e.printStackTrace();
            System.out.println("JAXBException: WEB");
            page = JspPageName.ERROR_PAGE;
            //logger
        } catch (Exception e) {
            page = JspPageName.ERROR_PAGE;
            System.out.println("Exception: WEB");
            //logger
        }
        if(responseParam.getShowResult()){
            req.setAttribute("SubCategories", responseParam.getCategory().getSubcategory());
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher(page);
        if (dispatcher != null) {
            dispatcher.forward(req, resp);
        } else {
            System.out.println("Instance of RequestDispatcher equals null");
            resp.getWriter().println("E R R O R");
        }
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
        HashMap<String, String> commandMap = new HashMap<>();
        commandMap.put("param", req.getParameter(COMMAND_NAME));
        commandMap.put("title", req.getParameter(TITLE));
        commandMap.put("director", req.getParameter(DIRECTOR));
        commandMap.put("date_of_issue", req.getParameter(DATE));
        commandMap.put("news_body", req.getParameter(NEWS_BODY));
        return new RequestParam(commandMap);
    }


    public static Controller getInstance() {
        return instance;
    }
}
