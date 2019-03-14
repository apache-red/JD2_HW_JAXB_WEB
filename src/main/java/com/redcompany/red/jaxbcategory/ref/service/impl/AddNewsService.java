package com.redcompany.red.jaxbcategory.ref.service.impl;

import com.redcompany.red.jaxbcategory.ref.entity.Category;
import com.redcompany.red.jaxbcategory.ref.entity.MovieType;
import com.redcompany.red.jaxbcategory.ref.entity.SubCategoryType;
import com.redcompany.red.jaxbcategory.ref.entity.service.RequestParam;
import com.redcompany.red.jaxbcategory.ref.entity.service.ResponseParam;
import com.redcompany.red.jaxbcategory.ref.service.XMLService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import static com.redcompany.red.jaxbcategory.ref.service.util.ServiceConstantStorage.*;

public class AddNewsService implements XMLService {

    private ResponseParam responseParam = new ResponseParam();
    private Category category;
    private static final AddNewsService instance = new AddNewsService();


    @Override
    public ResponseParam doService(RequestParam param) throws JAXBException {
        writeToXMLFile(param);
        responseParam.setRequestCompleted(true);
        return responseParam;
    }

    private void writeToXMLFile(RequestParam param) throws JAXBException {
        int idSubCategory;
        File file = new File(XML_FILE_PATH);
        JAXBContext context = null;
        context = JAXBContext.newInstance(JAXB_CONTEXT_PATH);
        readXMLFile(file,context);
        idSubCategory = getIdSubcategory(file,context);
        preparationEntity(param, file, context, idSubCategory);
        writeToXMLFile(file,context);
    }

    private void  writeToXMLFile( File file, JAXBContext context) throws JAXBException {
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(category, file);
    }

    private void readXMLFile(File file, JAXBContext context) throws JAXBException {
        Unmarshaller jaxbUnmarshaller = null;
        jaxbUnmarshaller = context.createUnmarshaller();
        category = (Category) jaxbUnmarshaller.unmarshal(file);
    }

    private int getIdSubcategory( File file,  JAXBContext context) throws JAXBException {
        List<SubCategoryType> list = category.getSubcategory();
        return (list.size()+1);
    }


    private void preparationEntity(RequestParam param, File file, JAXBContext context, int idSubCategory) throws JAXBException {
        String datefromString;
        HashMap<String, String> hashMapParam = param.getParam();
        SubCategoryType subCategoryType  = new SubCategoryType();
        subCategoryType.setId(idSubCategory);
        MovieType movieType = new MovieType();
        movieType.setId(1);
        movieType.setTitle(hashMapParam.get("title"));
        movieType.setDirector(hashMapParam.get("director"));
        datefromString = hashMapParam.get("date_of_issue");
        movieType.setDateOfIssue(convertDateToXMLGregorianCalendar(datefromString));
        movieType.setNewsBody(hashMapParam.get("news_body"));
        subCategoryType.getMovie().add(movieType);
        category.getSubcategory().add(subCategoryType);
    }


    private XMLGregorianCalendar convertDateToXMLGregorianCalendar(String datefromString){
        XMLGregorianCalendar result = null;
        try {
            result = DatatypeFactory.newInstance()
                    .newXMLGregorianCalendar(datefromString);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static AddNewsService getInstance() {
        return instance;
    }
}
