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
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.File;
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

        return null;
    }

    private void writeToXMLFile(RequestParam param) throws JAXBException {
        int idSubCategory = 1;
        File file = new File(XML_FILE_PATH);
        JAXBContext context = null;
        context = JAXBContext.newInstance(JAXB_CONTEXT_PATH);
        idSubCategory = getIdSubcategory(file,context);
        Marshaller marshaller  = context.createMarshaller();
        marshaller.marshal(  preparationEntity(param, file, context,idSubCategory), file);

    }

    private int getIdSubcategory( File file,  JAXBContext context) throws JAXBException {
        Unmarshaller unmarshaller = null;
        unmarshaller = context.createUnmarshaller();
        category = (Category) unmarshaller.unmarshal(file);
        List<SubCategoryType> list = category.getSubcategory();
        return (list.size()+1);
    }


    private SubCategoryType preparationEntity(RequestParam param, File file, JAXBContext context, int idSubCategory) throws JAXBException {
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
        return subCategoryType;
    }


    private XMLGregorianCalendar convertDateToXMLGregorianCalendar(String datefromString){
        Date date = null;
        try {
            date = new SimpleDateFormat( "yyyy.MM.dd" ).parse( datefromString );
        } catch (ParseException e) {
            e.printStackTrace();
        }
        XMLGregorianCalendar xmlDate = null;
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);

        try{
            xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
        }catch(Exception e){
            e.printStackTrace();
        }
        return xmlDate;
    }

    public static AddNewsService getInstance() {
        return instance;
    }
}
