package com.redcompany.red.jaxbcategory.ref.service.impl;

import com.redcompany.red.jaxbcategory.ref.entity.Category;
import com.redcompany.red.jaxbcategory.ref.entity.service.RequestParam;
import com.redcompany.red.jaxbcategory.ref.entity.service.ResponseParam;
import com.redcompany.red.jaxbcategory.ref.service.XMLService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

import static com.redcompany.red.jaxbcategory.ref.service.util.ServiceConstantStorage.*;

public class AllNewsService implements XMLService {

   private ResponseParam responseParam;
   private Category category;

    private static final AllNewsService instance = new AllNewsService();

    @Override
    public ResponseParam doService(RequestParam param) throws JAXBException {
        responseParam = readXmlFile();


        return null;
    }

    private ResponseParam readXmlFile() throws JAXBException {
        File file = new File(XML_FILE_PATH);
        JAXBContext context = null;
        context = JAXBContext.newInstance(JAXB_CONTEXT_PATH);
        Unmarshaller unmarshaller = null;
        unmarshaller = context.createUnmarshaller();

        category = (Category) unmarshaller.unmarshal(file);
        responseParam.setCategory(category);
//
//        ConsoleShow.getInstance().consoleShow(category);
        return null;
    }


    public static AllNewsService getInstance() {
        return instance;
    }

}
