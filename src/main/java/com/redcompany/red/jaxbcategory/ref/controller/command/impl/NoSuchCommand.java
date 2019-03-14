package com.redcompany.red.jaxbcategory.ref.controller.command.impl;

import com.redcompany.red.jaxbcategory.ref.controller.command.BasicCommand;
import com.redcompany.red.jaxbcategory.ref.entity.service.RequestParam;

public class NoSuchCommand implements BasicCommand {
    @Override
    public String performAction(RequestParam param) {
        return null;
    }
}
