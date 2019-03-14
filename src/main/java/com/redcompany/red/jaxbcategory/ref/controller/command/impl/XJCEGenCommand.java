package com.redcompany.red.jaxbcategory.ref.controller.command.impl;

import com.redcompany.red.jaxbcategory.ref.controller.command.BasicCommand;
import com.redcompany.red.jaxbcategory.ref.entity.service.RequestParam;
import com.redcompany.red.jaxbcategory.ref.entity.service.ResponseParam;
import com.redcompany.red.jaxbcategory.ref.service.impl.XJCEGenerationService;

public class XJCEGenCommand implements BasicCommand {

    @Override
    public ResponseParam performAction(RequestParam param) {

        XJCEGenerationService.getInstance().doService(param);
        return null;
    }
}
