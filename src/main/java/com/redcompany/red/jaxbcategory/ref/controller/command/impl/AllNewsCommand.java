package com.redcompany.red.jaxbcategory.ref.controller.command.impl;

import com.redcompany.red.jaxbcategory.ref.controller.command.BasicCommand;
import com.redcompany.red.jaxbcategory.ref.controller.util.JspPageName;
import com.redcompany.red.jaxbcategory.ref.entity.service.RequestParam;
import com.redcompany.red.jaxbcategory.ref.entity.service.ResponseParam;
import com.redcompany.red.jaxbcategory.ref.service.impl.AllNewsService;

import javax.xml.bind.JAXBException;

public class AllNewsCommand implements BasicCommand {

    private ResponseParam responseParam;

    @Override
    public ResponseParam performAction(RequestParam param) throws JAXBException {
        String page = null;
        responseParam =AllNewsService.getInstance().doService(param);
        if (responseParam.isRequestCompleted()){
            responseParam.setPageNames(JspPageName.ALL_NEWS_PAGE);
        }
        return responseParam;
    }
}
