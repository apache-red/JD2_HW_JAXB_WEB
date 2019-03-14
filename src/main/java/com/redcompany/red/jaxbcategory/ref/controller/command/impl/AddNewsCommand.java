package com.redcompany.red.jaxbcategory.ref.controller.command.impl;

import com.redcompany.red.jaxbcategory.ref.controller.command.BasicCommand;
import com.redcompany.red.jaxbcategory.ref.controller.util.JspPageName;
import com.redcompany.red.jaxbcategory.ref.entity.service.RequestParam;
import com.redcompany.red.jaxbcategory.ref.entity.service.ResponseParam;
import com.redcompany.red.jaxbcategory.ref.service.impl.AddNewsService;

import javax.xml.bind.JAXBException;

public class AddNewsCommand implements BasicCommand {

    private ResponseParam responseParam;

    @Override
    public ResponseParam performAction(RequestParam param) throws JAXBException {
        responseParam = AddNewsService.getInstance().doService(param);
        if (responseParam.isRequestCompleted()){
            responseParam.setPageNames(JspPageName.ADD_NEWS_PAGE);
        }
        return responseParam;
    }
}
