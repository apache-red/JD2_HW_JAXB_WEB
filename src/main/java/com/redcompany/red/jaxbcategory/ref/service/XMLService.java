package com.redcompany.red.jaxbcategory.ref.service;

import com.redcompany.red.jaxbcategory.ref.entity.service.RequestParam;
import com.redcompany.red.jaxbcategory.ref.entity.service.ResponseParam;

import javax.xml.bind.JAXBException;

public interface XMLService {

    ResponseParam doService(RequestParam param) throws JAXBException;

}
