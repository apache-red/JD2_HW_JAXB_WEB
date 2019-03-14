package com.redcompany.red.jaxbcategory.ref.controller.command;

import com.redcompany.red.jaxbcategory.ref.entity.service.RequestParam;
import com.redcompany.red.jaxbcategory.ref.entity.service.ResponseParam;

import javax.xml.bind.JAXBException;

public interface BasicCommand {

    ResponseParam performAction(RequestParam param) throws JAXBException;

}
