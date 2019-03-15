package com.redcompany.red.jaxbcategory.ref.entity.service;

import com.redcompany.red.jaxbcategory.ref.entity.Category;

public class ResponseParam {

    private Category category;
    private String pageNames;
    private boolean isRequestCompleted = false;
    private Boolean showResult = false;

    public ResponseParam() {

    }

    public Boolean getShowResult() {
        return showResult;
    }

    public void setShowResult(Boolean showResult) {
        this.showResult = showResult;
    }

    public boolean isRequestCompleted() {
        return isRequestCompleted;
    }

    public void setRequestCompleted(boolean requestCompleted) {
        isRequestCompleted = requestCompleted;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    public String getPageNames() {
        return pageNames;
    }

    public void setPageNames(String pageNames) {
        this.pageNames = pageNames;
    }
}
