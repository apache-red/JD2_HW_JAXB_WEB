package com.redcompany.red.jaxbcategory.ref.entity.service;

import java.util.HashMap;

public class RequestParam {

    private HashMap<String, String> param;

    public RequestParam(HashMap<String, String> param) {
        this.param = param;
    }

    public HashMap<String, String> getParam() {
        return param;
    }

    public void setParam(HashMap<String, String> param) {
        this.param = param;
    }
}
