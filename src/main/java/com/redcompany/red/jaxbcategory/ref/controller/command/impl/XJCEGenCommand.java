package com.redcompany.red.jaxbcategory.ref.controller.command.impl;

import com.redcompany.red.jaxbcategory.ref.controller.command.BasicCommand;
import com.redcompany.red.jaxbcategory.ref.controller.util.JspPageName;
import com.redcompany.red.jaxbcategory.ref.entity.service.RequestParam;
import com.redcompany.red.jaxbcategory.ref.entity.service.ResponseParam;
import com.redcompany.red.jaxbcategory.ref.service.impl.AllNewsService;
import com.redcompany.red.jaxbcategory.ref.service.impl.XJCEGenerationService;

public class XJCEGenCommand implements BasicCommand {

    private ResponseParam responseParam;
    @Override
    public ResponseParam performAction(RequestParam param) {


        String page = null;
        responseParam = XJCEGenerationService.getInstance().doService(param);;
        if (responseParam.isRequestCompleted()){
            responseParam.setPageNames(JspPageName.XJCE_GENERATION_PAGE);
        }
        return responseParam;
    }

}
