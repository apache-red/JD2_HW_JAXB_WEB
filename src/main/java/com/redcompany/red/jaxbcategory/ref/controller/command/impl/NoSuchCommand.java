package com.redcompany.red.jaxbcategory.ref.controller.command.impl;

import com.redcompany.red.jaxbcategory.ref.controller.command.BasicCommand;
import com.redcompany.red.jaxbcategory.ref.controller.util.JspPageName;
import com.redcompany.red.jaxbcategory.ref.entity.service.RequestParam;
import com.redcompany.red.jaxbcategory.ref.entity.service.ResponseParam;

public class NoSuchCommand implements BasicCommand {
    private ResponseParam responseParam;
    @Override
    public ResponseParam performAction(RequestParam param) {
        if (responseParam.isRequestCompleted()!=true){
            responseParam.setPageNames(JspPageName.ERROR_PAGE);
        }
        return responseParam;
    }
}
