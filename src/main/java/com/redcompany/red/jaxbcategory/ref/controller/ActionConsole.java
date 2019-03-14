package com.redcompany.red.jaxbcategory.ref.controller;

import com.redcompany.red.jaxbcategory.ref.entity.service.ResponseParam;
import java.util.HashMap;

public interface ActionConsole {

   ResponseParam doAction(HashMap<String, String> action);
}
