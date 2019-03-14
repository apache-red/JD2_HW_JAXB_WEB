package com.redcompany.red.jaxbcategory.ref.entity.service;

import com.redcompany.red.jaxbcategory.ref.entity.Category;

public class ResponseParam {

    private Category category;

    private boolean isRequestCompleted = false;

    public ResponseParam() {

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
}
