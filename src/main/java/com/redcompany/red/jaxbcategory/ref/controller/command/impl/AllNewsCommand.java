package com.redcompany.red.jaxbcategory.ref.controller.command.impl;

import com.redcompany.red.jaxbcategory.ref.controller.command.BasicCommand;
import com.redcompany.red.jaxbcategory.ref.entity.service.RequestParam;
import com.redcompany.red.jaxbcategory.ref.service.impl.AllNewsService;

import javax.xml.bind.JAXBException;

public class AllNewsCommand implements BasicCommand {
    @Override
    public String performAction(RequestParam param) {

        try {
            AllNewsService.getInstance().doService(param);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return null;
    }
}
