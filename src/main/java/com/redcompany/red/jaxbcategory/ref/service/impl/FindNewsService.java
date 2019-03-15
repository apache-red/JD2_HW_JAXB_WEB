package com.redcompany.red.jaxbcategory.ref.service.impl;

import com.redcompany.red.jaxbcategory.ref.entity.Category;
import com.redcompany.red.jaxbcategory.ref.entity.MovieType;
import com.redcompany.red.jaxbcategory.ref.entity.SubCategoryType;
import com.redcompany.red.jaxbcategory.ref.entity.service.RequestParam;
import com.redcompany.red.jaxbcategory.ref.entity.service.ResponseParam;
import com.redcompany.red.jaxbcategory.ref.service.XMLService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import static com.redcompany.red.jaxbcategory.ref.service.util.ServiceConstantStorage.JAXB_CONTEXT_PATH;
import static com.redcompany.red.jaxbcategory.ref.service.util.ServiceConstantStorage.XML_FILE_PATH;

public class FindNewsService implements XMLService {

    private static final FindNewsService instance = new FindNewsService();
    private ResponseParam responseParam = new ResponseParam();
    private Category category;
    private List<SubCategoryType> subCategoryTypeList;
    private List<MovieType> movieTypeList;
    private MovieType movieType;
    private HashMap<String, String> searchParam;

    @Override
    public ResponseParam doService(RequestParam param) throws JAXBException {
        buildSearchRequest(param);
        if (searchParam.size() == 0) {
            responseParam.setRequestCompleted(false);
            return responseParam;
        }
        findNews();
        responseParam.setRequestCompleted(true);
        return responseParam;
    }

    private void findNews() throws JAXBException {
        readXmlFile();
        subCategoryTypeList = category.getSubcategory();
        for (int i = 0; i < subCategoryTypeList.size(); i++) {
            movieTypeList = subCategoryTypeList.get(i).getMovie();
            for (int j = 0; j < movieTypeList.size(); j++) {
                movieType = movieTypeList.get(j);
                if (findParamInMovie(movieType) != true){
                    movieTypeList.remove(movieType);
                }
            }
        }
        responseParam.setCategory(category);
    }


    private boolean findParamInMovie(MovieType movieType) {
        boolean result = false;
        String current = "";
        Set<String> keySet = searchParam.keySet();
        if (keySet.contains("title")) {
            current = movieType.getTitle();
            result = current.equals(searchParam.get("title")) == true? true:false;
            }
        if (keySet.contains("director")) {
            current = movieType.getDirector();
            result = current.equals(searchParam.get("director")) == true? true:false;
        }
        if (keySet.contains("date")) {
            current = movieType.getDateOfIssue().toString();
            result = current.equals(searchParam.get("date")) == true? true:false;
        }
        if (keySet.contains("news_body")) {
            current = movieType.getNewsBody();
            result = current.equals(searchParam.get("news_body")) == true? true:false;
        }
        return result;
    }




    private void readXmlFile() throws JAXBException {
        File file = new File(XML_FILE_PATH);
        JAXBContext context = JAXBContext.newInstance(JAXB_CONTEXT_PATH);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        category = (Category) unmarshaller.unmarshal(file);
    }

    private void buildSearchRequest(RequestParam param) {
        searchParam = param.getParam();
        Collection<String> values = searchParam.values();
        while (values.remove("")) {
        }
        searchParam.remove("param");

    }


    public static FindNewsService getInstance() {
        return instance;
    }
}
